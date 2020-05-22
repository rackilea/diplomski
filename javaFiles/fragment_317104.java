/*Create your second EClass*/
    EClass mySecondEClass = ecoreFactory.createEClass();
    mySecondEClass.setName("mySecondClass");
    myPackage.getEClassifiers().add(mySecondEClass);

    /*now, the firstClass should hold instances of secondClass*/
    /*1. create EReference (Ereferences unlike EAttributes define relationships between EClasses)*/
    EReference secondClassesRef = ecoreFactory.createEReference();
    secondClassesRef.setName("secondClasses");
    /*set containment true -> every EObject must have a Container*/
    secondClassesRef.setContainment(true);
    /*set Type to your EClass*/
    secondClassesRef.setEType(mySecondEClass);
    /*set upperbound -> now the reference is an EList*/
    secondClassesRef.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);

    /*finally add ERef to EClass*/
    myFirstEClass.getEStructuralFeatures().add(secondClassesRef);

    /*and for example supertypes*/
    myFirstEClass.getESuperTypes().add(mySecondEClass);