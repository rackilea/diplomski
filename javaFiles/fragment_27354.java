Expression expression = filterOption.getExpression();
QueryBuilder queryBuilder
           = expression.accept(new ExpressionVisitor() {
    (...)

    @Override
    public Object visitBinaryOperator(
              BinaryOperatorKind operator, Object left,
              Object right) throws ExpressionVisitException,
                                  ODataApplicationException {
        String fieldName = (String)left;
        // Simplification but not really clean code ;-)
        String value = ((String)right).substring(
                          1, right.length() - 1);
        return QueryBuilders.termQuery((String) left, right);
    }

    @Override
    public Object visitLiteral(String literal)
                throws ExpressionVisitException,
                ODataApplicationException {
        return literal;
    }

    @Override
    public Object visitMember(UriInfoResource member)
                throws ExpressionVisitException,
                ODataApplicationException {
        UriResourcePrimitiveProperty property
                   = (UriResourcePrimitiveProperty)
                          member.getUriResourceParts().get(0);
        return property.getProperty().getName();
    }
}