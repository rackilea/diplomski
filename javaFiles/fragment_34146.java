List<Expression<?>> expressions = ((PredicateOperation) filter).getArgs();
for (Expression<?> expression : expressions)
{
    String expressionPath = expression.accept(PathExtractor.DEFAULT, null).toString();
    Constant constant = expression.accept(ConstantExtractor.DEFAULT, null);
}