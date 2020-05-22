ParameterizedTypeName.get( 
    ClassName.get(SuperClass.class),
    ClassName.get(TypeArgumentA.class),
    ClassName.get(TypeArgumentB.class),
    ClassName.get(TypeArgumentC.class)
); // equivalent to SuperClass<TypeArgumentA, TypeArgumentB, TypeArgumentC>