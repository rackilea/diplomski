@Override
public List<Auction> getAuctionByRefineAndSearch(Integer categoryId,
        String text, Float startPrice, Float endPrice)
        throws EntityNotFoundException {

    boolean notNull = false;
    List<Auction> foundAuctions = new ArrayList<Auction>();

    Criteria criteria = getCurrentSession().createCriteria(Auction.class);
    // check if the parameters are not null

    // check if the startPrice are not null
    if (startPrice != null) {
        System.out.println("startPrice=" + startPrice);
        criteria.add(Restrictions.ge("reservedPrice", startPrice));
    }
    // check if endPrice is not null
    if (endPrice != null) {
        System.out.println("endPrice=" + endPrice);
        criteria.add(Restrictions.le("reservedPrice", endPrice));
    }
    // check if the text is null
    if (text != null) {
        notNull = true;
        criteria.createCriteria("item").add(
                Restrictions
                        .disjunction()
                        .add(Restrictions.like("name", "%" + text + "%",
                                MatchMode.ANYWHERE))
                        .add(Restrictions.like("description", "%" + text
                                + "%", MatchMode.ANYWHERE)));
    }
    // check if categoryId is not null
    if (categoryId != null) {
        if (notNull) {
            criteria.createCriteria("category").add(
                    Restrictions.eq("id", categoryId));
        } else {
            criteria.createCriteria("item").createCriteria("category")
                    .add(Restrictions.eq("id", categoryId));
        }
    }

    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    foundAuctions = criteria.list();

    if (foundAuctions.size() > 0) {
        return foundAuctions;
    } else {
        throw new EntityNotFoundException(
                "Auctions matching criteria can not be found");
    }
}