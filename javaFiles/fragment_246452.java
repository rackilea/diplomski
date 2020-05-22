List<User> lu = new ArrayList<User>();
lu.add(new User("Short user name"));
lu.add(new User("Very long user name which should be shortend"));

ExpressionParser parser = new SpelExpressionParser();
EvaluationContext context = new StandardEvaluationContext(lu);

List<String> names = (List<String>)parser.parseExpression("![name.length() > 20 ? name.substring(0,20) : name]").getValue(context);

for (String name : names) {
    System.out.println("Name: " + name);
}