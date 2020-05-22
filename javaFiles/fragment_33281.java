private static void sparqlTst() {
        FileManager.get().addLocatorClassLoader(Jena_Enigma.class.getClassLoader());
        Model model = FileManager.get().loadModel("http://www.heshjayasinghe.webatu.com/Enigma.RDF");
         model.write(System.out, "RDF/JSON");
        String queryString = "PREFIX sep: <http://www.heshjayasinghe.webatu.com/Enigma.RDF#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT  ?x "
                + "WHERE {"

                + "?User  sep:email \"heshjse@gmail.com\"."
                + "?User sep:password \"123\"."
                + "?User sep:fname ?x. "
                + "}";

        Query query = QueryFactory.create(queryString);
      //  System.out.println(query);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            System.out.println(results);
            while (results.hasNext()) {
                QuerySolution soln = results.nextSolution();
                Literal name = soln.getLiteral("x");
                System.out.println(name);


            }
        } finally {
            qexec.close();
        }

    }