public static void main(String[] args) {
    String strDuration = "4560";
    long lDuration = Long.parseLong(strDuration);
    String theExpression = "(lDuration > 500) ? true : false;";
    JexlEngine jexl = new JexlEngine();
    Expression e = jexl.createExpression(theExpression);
    JexlContext context = new MapContext();
    context.set("lDuration", lDuration);
    Boolean result = (Boolean) e.evaluate(context);
    System.out.println("The answer : " + result);
  }