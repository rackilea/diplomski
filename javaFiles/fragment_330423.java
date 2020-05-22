// Setup the SpEL parser: do this once
SpelParserConfiguration spelParserConfiguration = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, getClass().getClassLoader());
ExpressionParser expressionParser = new SpelExpressionParser(spelParserConfiguration);
StandardEvaluationContext evaluationContext = new StandardEvaluationContext();

// Parse (compile) the expression: try to do this once
Expression expression = expressionParser.parseExpression(unevaluatedExpression)

// Then within the loop ...

// Supply context, like the value of your namespace
evaluationContext.setVariable(variableName, value);

// Evaluate an expression as many times as you like
Object result = expression.getValue(evaluationContext);