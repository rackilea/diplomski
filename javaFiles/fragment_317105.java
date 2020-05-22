/*
     * Save your EPackage to file ecore file:
     */

    /*Initialize your EPackage*/
    myPackage.eClass();
    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
    Map<String, Object> m = reg.getExtensionToFactoryMap();
    /*add default .ecore extension for ecore file*/
    m.put(EcorePackage.eNAME, new XMIResourceFactoryImpl());

    // Obtain a new resource set
    ResourceSet resSet = new ResourceSetImpl();
    // create a resource
    Resource resource = null;
    try {
        resource = resSet.createResource(URI.createFileURI("/Your/Path/To/Directory/myTest.ecore"));
    } catch (Exception e) {
        e.printStackTrace();
    }
    /*add your EPackage as root, everything is hierarchical included in this first node*/
    resource.getContents().add(myPackage);

    // now save the content.
    try {
        resource.save(Collections.EMPTY_MAP);
    } catch (IOException e) {
        e.printStackTrace();
    }