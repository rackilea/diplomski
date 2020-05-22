@Override public Predicate toPredicate(Root<Message> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
    // Note - this would be simpler if JPA allowed subqueries in joins. As it doesn't,
    // we have to put the subquery in a where clause, join both sides with the mailbox
    // and correlate the results

    // join the main query on the mailbox (for the ORDER BY clause)
    Join<Message, MessageOwner> messageOwners = root.join("messageOwners", JoinType.LEFT);
    Join<Message, Mailbox> mailbox = messageOwners.join("owner");

    // create a subquery and correlate the messages with the main query
    Subquery<String> subQuery = query.subquery(String.class);
    Root<Message> sqMessage = subQuery.from(Message.class);
    Root<Message> correlateMessage = subQuery.correlate(root);

    // join the subquery on the mailbox
    Join<Object, Object> sqMessageOwners = sqMessage.join("messageOwners", JoinType.LEFT);
    Join<Message, Mailbox> sqMailbox = sqMessageOwners.join("owner");

    // get the lowest ldapId alphabetically 
    Expression<String> minLdapId = cb.least(sqMailbox.<String>get("ldapId"));

    // the actual subquery
    // select the lowest ldapId for the current message (see the group-by clause)
    // where the recipient type is TO and the message is the same as the main query
    subQuery.select(minLdapId)  
            .where(
                    cb.and(     
                            cb.equal(sqMessageOwners.get("type"), MessageOwnerType.TO),
                            cb.equal(sqMessage, correlateMessage)))
            .groupBy(sqMessage.get("id")); 

    // the subquery gives us the lowest TO recipient for each mail
    // sort on these values. Note: his must be done here rather than in the Sort property
    // of the Pageable in order to maintain the connection between the mailbox in the order by clause
    // and the one in the subquery
    Path<String> recipientOrderClause = mailbox.get("ldapId");
    Order recipientOrder = sortDirection == Sort.Direction.ASC ? cb.asc(recipientOrderClause) : cb.desc(recipientOrderClause);

    // secondary sorting descending by sendTime
    Order sendTimeOrder = cb.desc(root.get("sendTime"));

    // adding order by queries here, rather than via the Sort object
    // is something of a violation of standard Spring Data practice. (see above for the reason it is done)
    // this precludes us from making some grouped calls such as select count(*)
    query.orderBy(recipientOrder, sendTimeOrder);

    // attach the subquery onto the query and return.
    return cb.equal(mailbox.get("ldapId"), subQuery);
}