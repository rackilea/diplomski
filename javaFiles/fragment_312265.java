private String getFieldType(Class cls, String fieldName) throws NoSuchFieldException {
    Field field = cls.getField(fieldName);
    TypeVariable fieldTypeVariable = (TypeVariable) field.getGenericType();

    int typeVariableIndex = -1;
    TypeVariable[] superclassTypeVariables = cls.getSuperclass().getTypeParameters();
    for (int i = 0; i < superclassTypeVariables.length; i++) {
        TypeVariable classTypeVariable = superclassTypeVariables[i];
        if (classTypeVariable.equals(fieldTypeVariable)) {
            typeVariableIndex = i;
            break;
        }
    }

    ParameterizedType genericSuperclass = (ParameterizedType) cls.getGenericSuperclass();
    Class<?> actualType = (Class<?>) genericSuperclass.getActualTypeArguments()[typeVariableIndex];
    return actualType.getSimpleName();
}