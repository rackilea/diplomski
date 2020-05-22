List<Bson> keyFilters = new ArrayList<>();
// for each key create an 'and' filter on seniority, currency, redcode and companyid
for (Key key : keys) {        
    keyFilters.add(
        Filters.and(eq("m_seniority", key.getM_seniority()),
            Filters.eq("m_currency",key.getM_currency()),
            Filters.eq("m_redCode",key.getM_redCode()),
            Filters.eq("m_companyId",key.getM_companyId())
        )
    );
}

List<Document> docs =  (List<Document>) collection.find(
        // 'or' all of the individual key filters
        Filters.or(keyFilters)
).into(new ArrayList<Document>());