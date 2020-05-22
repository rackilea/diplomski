String name = "kocko";
ctx.setVariable("name", kocko);
String statement = "#root.stringLength(#kocko) == 5";
Expression expression = parser.parseExpression(statement);

boolean result = expression.getValue(context, Boolean.class);