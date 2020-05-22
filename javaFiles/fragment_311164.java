// access to internal Hibernate of EntityManager
        query.unwrap(SQLQuery.class)
                .addScalar("total", LongType.INSTANCE)
                .addScalar("amountOfSales", LongType.INSTANCE)
                .addScalar("amountOfProducts", LongType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(SaleStatsInfo.class));

        ...
        query.getSingleResult();