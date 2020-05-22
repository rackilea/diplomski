class A implements EdmStructuredType, EdmPrimitiveType {

    @Override
    public boolean isCompatible(EdmPrimitiveType edmPrimitiveType) {
        return false;
    }

    @Override
    public Class<?> getDefaultType() {
        return null;
    }

    @Override
    public boolean validate(String s, Boolean aBoolean, Integer integer, Integer integer1, Integer integer2, Boolean aBoolean1) {
        return false;
    }

    @Override
    public <T> T valueOfString(String s, Boolean aBoolean, Integer integer, Integer integer1, Integer integer2, Boolean aBoolean1, Class<T> aClass) throws EdmPrimitiveTypeException {
        return null;
    }

    @Override
    public String valueToString(Object o, Boolean aBoolean, Integer integer, Integer integer1, Integer integer2, Boolean aBoolean1) throws EdmPrimitiveTypeException {
        return null;
    }

    @Override
    public String toUriLiteral(String s) {
        return null;
    }

    @Override
    public String fromUriLiteral(String s) throws EdmPrimitiveTypeException {
        return null;
    }

    @Override
    public EdmElement getProperty(String s) {
        return null;
    }

    @Override
    public List<String> getPropertyNames() {
        return null;
    }

    @Override
    public EdmProperty getStructuralProperty(String s) {
        return null;
    }

    @Override
    public EdmNavigationProperty getNavigationProperty(String s) {
        return null;
    }

    @Override
    public List<String> getNavigationPropertyNames() {
        return null;
    }

    @Override
    public EdmStructuredType getBaseType() {
        return null;
    }

    @Override
    public boolean compatibleTo(EdmType edmType) {
        return false;
    }

    @Override
    public boolean isOpenType() {
        return false;
    }

    @Override
    public boolean isAbstract() {
        return false;
    }

    @Override
    public EdmAnnotation getAnnotation(EdmTerm edmTerm, String s) {
        return null;
    }

    @Override
    public List<EdmAnnotation> getAnnotations() {
        return null;
    }

    @Override
    public FullQualifiedName getFullQualifiedName() {
        return null;
    }

    @Override
    public String getNamespace() {
        return null;
    }

    @Override
    public EdmTypeKind getKind() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}


private Expression parseExpression(final String expressionString)
        throws UriParserException, UriValidationException {

    UriTokenizer tokenizer = new UriTokenizer(expressionString);

    Edm edm = mock(A.class, withSettings().defaultAnswer(RETURNS_SMART_NULLS));
    EdmProperty employeeIdTypeEdmElement = mock(EdmProperty.class, RETURNS_SMART_NULLS);

    when(edmType.getProperty("EmployeeId")).thenReturn(measureTypeEdmElement);

    when(edmType.getKind()).thenReturn(EdmTypeKind.PRIMITIVE);
    when(edmType.isCompatible(new EdmDate())).thenReturn(true);

    when(employeeIdTypeEdmElement.getName()).thenReturn("EmployeeId");
    when(employeeIdTypeEdmElement.getType()).thenReturn(edmType);
    when(employeeIdTypeEdmElement.isCollection()).thenReturn(false);


    final Expression expression = new ExpressionParser(edm, odata).parse(tokenizer, edmType, null, null);
    assertNotNull(expression);
    assertTrue(tokenizer.next(UriTokenizer.TokenKind.EOF));
    return expression;
}