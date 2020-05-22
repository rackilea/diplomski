CriteriaQuery<Tuple> cq = builder.createTupleQuery();
Root<Company> company = cq.from(Company.class);
Join<Company, Asset> secondTable = company.join("assets", JoinType.LEFT);
cq.multiselect(company.<String>get("id").alias("id"), builder.count(secondTable).alias("assetCount"));
cq.groupBy( company.<Long>get("id") );

Query query = em.createQuery(cq);
List<Tuple> results = query.getResultList();