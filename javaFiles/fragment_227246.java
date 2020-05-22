// Let's rename your Object class to Literal so we don't get confused with java.lang.Object
Instance instance = new Instance();
localAcademic.dataPropertyAssertionAxioms()
    .forEach(ax -> instance.predicateToObject.put(
        ax.getProperty().getIRI().toString(),
        Collections.singleton(new Literal(ax.getObject))));