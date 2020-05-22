/*
     * load existing EPackage
     */
    EcorePackage.eINSTANCE.eClass();
    /*Initialize your EPackage*/
    final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
    final Map<String, Object> m = reg.getExtensionToFactoryMap();
    m.put(EcorePackage.eNAME, new XMIResourceFactoryImpl());

    final ResourceSet resSet = new ResourceSetImpl();
    Resource resource = null;
    try {
        resource = resSet.getResource(URI.createFileURI("/Your/Path/To/Directory/myTest.ecore"), true);
    } catch (Exception e) {
        e.printStackTrace();
    }
    /*load root and cast to EPackage*/
    final EPackage root = (EPackage) resource.getContents().get(0);