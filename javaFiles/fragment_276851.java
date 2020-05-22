findTroublesomeQuery(BooleanQuery query) {
    for (BooleanClause clause : query.clauses()) {
        Query subquery = clause.getQuery()
        TopDocs docs = searchHoweverYouDo(subquery);
        if  (doc.totalSize == 0) {
            //If you want to dig down recursively...
            if (subquery instanceof BooleanQuery)
                findTroublesomeQuery(query);
            else 
                log(query); //Or do whatever you want to keep track of it.
        }
    }
}