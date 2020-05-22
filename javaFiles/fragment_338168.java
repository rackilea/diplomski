List<String> eids = ...;

QueryBuilder qb = getQueryBuilder();

BooleanJunction<?> idJunction = qb.bool();

for (String eid : eids) {
    idJunction.should(
            qb.keyword()
                .onField("eid")
                .matching(eid)
                .createQuery()
    );
}

return idJunction.createQuery();