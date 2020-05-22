public List<Integer> getPendingItems(int channelId, int start, int pageSize) {
    Query query = sessionFactory.getCurrentSession().createQuery(
            "select cit.id 
             from Item cit 
             where cit.channel.id = :channelId and (cit.statusCode = 'NEW' or cit.statusCode = 'FAILED' or ID = 'successId' or ID = 'otherSuccessId' or ID = 'thirdSuccessId')");
    query.setParameter("channelId", channelId);
    query.setMaxResults(pageSize);
    query.setFirstResult(start);
    return query.list();
}