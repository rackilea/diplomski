private String getDummyValue(String authExpression,  Object[] args){
    Expression expression = expressionParser.parseExpression(authExpression, parserContext);
    String value = expression.getValue(new RootObject(args),String.class);
    return value;
}


private static class TemplateparserContext implements ParserContext{

    @Override
    public boolean isTemplate() {
        return true;
    }

    @Override
    public String getExpressionPrefix() {
        return "#{";
    }

    @Override
    public String getExpressionSuffix() {
        return "}";
    }

}

 protected static class RootObject {

        private final Object[] args;

        private RootObject(Object[] args) {
            super();
            this.args = args;
        }

        public Object[] getArgs() {
            return args;
        }
    }