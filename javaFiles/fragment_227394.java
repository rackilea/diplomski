boolean willMatchAll(Query query) {
    if (query instanceof MatchAllDocsQuery)
        return true;
    }
    else if (query instanceof BooleanQuery) {
        boolean foundMatchAll = false;
        for (BooleanClause clause : ((BooleanQuery)query).getClauses()) {
            if (clause.isProhibited()) {
                return false; //A reasonable assumption, that the MUST_NOT clauses won't be empty
            }
            else if (clause.isRequired()) {
                if (willMatchAll(clause.getQuery())) {
                    foundMatchAll = true;
                } else {
                    return false; //any MUST clause that is not a matchall means the boolean query will not match all
                }
            }
            else {
                if (willMatchAll(clause.getQuery())) {
                    foundMatchAll = true;
                }
            }
        }
        //If a matchall has been found, and we haven't return false yet, this boolean query matches all documents
        return foundMatchAll;
    }
    else if (query instanceof DisjunctionMaxQuery) {
        boolean isMatchAll = false
        //If any disjunct is a matchall, the query will match all documents
        for (Query subquery : ((DisjunctuionMaxQuery)query).getDisjuncts()) {
            isMatchAll = isMatchAll || willMatchAll(subquery);
        }
        return isMatchAll;
    }
    else if (query instanceof ConstantScoreQuery) {
        //Traverse right through ConstantScoreQuery.  The wrapper isn't of interest here.
        Query subquery = ((ConstantScoreQuery)query).getQuery()
        if (subquery == null) {
            return false; //It wraps a filter, not a query, and I don't believe a filter can be a matchall
        }
        return willMatchAll(subquery);
    }
    else {
        //No other standard queries may be or contain MatchAllDocsQueries, I don't believe.
        //Even a double open-ended range query restricts the results to those with a value in the specified field.
        return false; 
    }
}