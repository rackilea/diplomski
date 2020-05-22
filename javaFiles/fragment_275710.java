try {
        TupleQuery tupleQuery = test.repConn.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
        TupleQueryResult queryResult = tupleQuery.evaluate();
        queryResult.close(); // this should solve your issue

    }