// Create a new query
        String queryString = 
            "SELECT ?property ?object " +
            "WHERE {" +
            "      <"+resourceURI+"> ?property ?object ." + 
            "}";

        Query query = QueryFactory.create(queryString);