public static String getAllTriplesOfContext(URL context) throws IOException {

            String query = new String("SELECT ?x ?y ?z \n" + "FROM ?context \n"
                            + "WHERE {?x ?y ?z}");

            ParameterizedSparqlString queryString = new ParameterizedSparqlString(
                            query);

            queryString.setIri("?context", context);

            return queryString.toString();

    }