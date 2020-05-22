ElementPathBlock triplePattern = new ElementPathBlock();
    Node typ = NodeFactory.createVariable("typ");
    Node sometype = ...; // Assume OK
    // This represents rdfs:subClassOf+
    Path pathSubClassOfPlus = PathFactory.pathOneOrMore1(
        PathFactory.pathLink(RDFS.subClassOf.asNode())
    );
    // This represents the SPARQL: ?typ rdfs:subClassOf+ sometype .
    TriplePath subClassOfPlus = new TriplePath(typ, pathSubClassOfPlus, sometype)
    triplePattern.addTriplePath(subClassOfPlus);
    // ... One can also add regular Triple instances afterwards
    query.setQueryPattern(triplePattern);