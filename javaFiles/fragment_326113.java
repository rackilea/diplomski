QueryBuilder qb = new BoolQueryBuilder()
    .minimumNumberShouldMatch(1)
    .should(QueryBuilders.multiMatchQuery(term, "phoneticFirstName", "phoneticLastName", "phoneticLocationName", "phoneticCompanyName")
            .analyzer("atsCustomSearchAnalyzer")
            .operator(Operator.AND))
    .should(QueryBuilders.multiMatchQuery(term, "ngramFirstName^3", "ngramLastName^3", "ngramLocationName^3", "ngramCompanyName^3", "_all")
            .analyzer("atsCustomSearchAnalyzer")
            .operator(Operator.AND));