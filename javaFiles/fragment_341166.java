DetachedCriteria dtcrt = DetachedCriteria.forClass(Clients.class);
        dtcrt.setProjection(Projections.distinct(Projections.id()));    
if (clOrdsTtlPrcFrom != -1 && clOrdsTtlPrcTo != -1) {
            dtcrt.add(Restrictions.sqlRestriction("OwnerID in(select OwnerID from Orders group by " +
                            "OwnerID having sum(Total) >= ? and sum(Total) <= ?)", new Integer[]{clOrdsTtlPrcFrom, clOrdsTtlPrcTo},
                    new Type[]{StandardBasicTypes.INTEGER, StandardBasicTypes.INTEGER}));
            criteria.add(Subqueries.propertyIn("id", dtcrt));
        }