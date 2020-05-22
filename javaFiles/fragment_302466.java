/*
 * Base b = new Derived(); // How do I get packageNAME.Derived?
 */
private String getClassNameFromConstructor(VariableDeclarationFragment fragment) {
    Expression initializer = fragment.getInitializer();
    if (initializer instanceof ClassInstanceCreation) {
        ClassInstanceCreation instanceCreation = (ClassInstanceCreation)initializer;
        if (instanceCreation.getType() instanceof SimpleType) {
            SimpleType simpleType = (SimpleType)instanceCreation.getType();
            return simpleType.getName().getFullyQualifiedName();
        }
    }
    return null;
}

/*
 * int x = 5; // How do I get 5?
 */
private String getInitialisationNumber(VariableDeclarationFragment fragment) {
    Expression initializer = fragment.getInitializer();
    if (initializer instanceof NumberLiteral) {
        NumberLiteral numberLiteral = (NumberLiteral)initializer;
        return numberLiteral.getToken();
    }
    return null;
}