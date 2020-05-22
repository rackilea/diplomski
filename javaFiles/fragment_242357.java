public Stack<String> getStack(String expression){
    Stack<String> stack = new Stack<>();
    Pattern pattern = Pattern.compile("[0-9a-z]+|\\+|\\*");
    Matcher matcher = pattern.matcher(expression);
    while(matcher.find()) {
       stack.push(matcher.group());
    }
    System.out.println(stack.toString());
    return stack;
}