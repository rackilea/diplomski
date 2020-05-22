String service = "http://dbpedia.org/sparql";
        String queryString = "";
        queryString = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> SELECT ?label " +
            "WHERE {" +
             "<http://dbpedia.org/resource/Quatre_Bornes> <http://dbpedia.org/ontology/country> ?y ."+
             "?y rdfs:label ?label ."+ 
             "FILTER (LANG(?label) = 'en')"+
            "}";