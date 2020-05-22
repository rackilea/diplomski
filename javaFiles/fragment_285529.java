String NS = "http://example.com/test#";
    Model m = ModelFactory.createDefaultModel();
    Resource r = m.createResource("http://meetup/nyc");

    Property p = m.createProperty(NS + "hasData");

    m.add(r, p, "somedata");
    m.add(r, p, "more data");

    m.write(System.out);