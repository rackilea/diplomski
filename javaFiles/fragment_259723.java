LinearDefinition ld = gazetter.getLinearDefinition();

    //add .lst record
    LinearNode ln = new LinearNode("glossary.lst", "minor", "major", "en", "AnnotType");
    ld.add(ln);

    //add Lookup record
    Map<String, Object> features = new HashMap<>();
    features.put("someFeatureName", "some value");
    GazetteerNode gn = new GazetteerNode("string to be found", features);
    gn.setSeparator("@");
    GazetteerList theList = ld.getListsByNode().get(ln);
    theList.add(gn);

    //save updated files 
    theList.store();
    ld.store();

    //optionally re-init the gazetteer to make changes to work 
    gazetter.reInit();