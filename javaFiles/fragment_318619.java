Model model = ...

    model.addLiteral (subject, predicate, 10);
    model.addLiteral (subject, predicate, 0.5);
    model.addLiteral (subject, predicate, (float)0.5);
    model.addLiteral (subject, predicate, ResourceFactory.createTypedLiteral(20));
    model.addLiteral (subject, predicate, ResourceFactory.createTypedLiteral(0.99));
    model.addLiteral (subject, predicate, true);
    model.add (subject, predicate, ResourceFactory.createTypedLiteral("2012-03-11", XSDDatatype.XSDdate));
    model.add (subject, predicate, ResourceFactory.createTypedLiteral("P2Y", XSDDatatype.XSDduration));