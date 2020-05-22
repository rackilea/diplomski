for(char c : arr) {

    switch(c) {

    case '{':
        stack.push(c);
        System.out.print(stack.peek());
        break;
    case '(':
        stack.push(c);
        System.out.print(stack.peek());
        break;
    case '[':
        stack.push(c);
        System.out.print(stack.peek());
        break;

    case '}':
        if(stack.isEmpty() || (Character) stack.pop() != '{') {
            System.out.println("  Syntax ERROR");
        }
        break;
    case ']':
        if(stack.isEmpty() || (Character) stack.pop() != '[') {
            System.out.println("  Syntax ERROR");
        }
        break;
    case ')':
        if(stack.isEmpty() || (Character) stack.pop() != '(') {
            System.out.println("  Syntax ERROR");
        }
        break;
    }
}