/*Use the Ecore factory*/
    EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
    /*Create your EPackage*/
    EPackage myPackage = ecoreFactory.createEPackage();
    /*set EPackage properties*/
    myPackage.setName("myTest");
    myPackage.setNsPrefix("myTest");
    myPackage.setNsURI("http://com.myTest");

    /*Create your first EClass*/
    EClass myFirstEClass = ecoreFactory.createEClass();
    myFirstEClass.setName("myClass");
    /*Add to your EPackage's EClassifiers*/
    /*EClasses and EDatatypes implement both EClassifiers*/
    myPackage.getEClassifiers().add(myFirstEClass);

    /*Create your first EAtttribute*/
    EAttribute myFirstEAtt = ecoreFactory.createEAttribute();
    myFirstEAtt.setName("name");
    /*Use the EcorePackage Datatypes -> here EString*/
    myFirstEAtt.setEType(EcorePackage.eINSTANCE.getEString());
    /*use EStructuralFeatures to add your EAtt*/
    /*EReferences and EAttributes are both EStructuralfeatures*/
    myFirstEClass.getEStructuralFeatures().add(myFirstEAtt);