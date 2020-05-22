String query = "\n" +
        "prefix rdfs: <"+RDFS.getURI()+">\n" +
        "\n" +
        "select distinct ?class where {\n" +
        "  { ?class a rdfs:Class } union\n" +
        "  { ?class rdfs:subClassOf|^rdfs:subClassOf [] }\n" +
        "}";
ResultSet results = QueryExecutionFactory.create( query, base ).execSelect();
System.out.println( query );
ResultSetFormatter.out( results );