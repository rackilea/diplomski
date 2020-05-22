Type myType = MyClass.class;

// get the parameterized type, recursively resolving type parameters
Type baseType = GenericTypeReflector.getExactSuperType(myType, BaseInterface.class);

if (baseType instanceof Class<?>) {
    // raw class, type parameters not known
    // ...
} else {
    ParameterizedType pBaseType = (ParameterizedType)baseType;
    assert pBaseType.getRawType() == BaseInterface.class; // always true
    Type typeParameterForBaseInterface = pBaseType.getActualTypeArguments()[0];
    System.out.println(typeParameterForBaseInterface);
}