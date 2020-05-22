static String  isBalanced(String s) {
    Stack<Character> bracket = new Stack<Character>();

    String decision;
    char element;
    //char[] s_new = s.toCharArray();

    for (int i = 0; i < s.length(); i++) {
        element = s.charAt(i);
        if (element == '{' || element == '[' || element == '(')
            bracket.push(element);
        else if(bracket.empty() && (element =='}' || element ==']' || element ==')'))
        {
            bracket.push(element);
            break;
        } // *******Added this 'else if' block  to support point no 2*******


        if ((!bracket.empty()) && (element == '}') && (bracket.peek() == '{'))
            bracket.pop();
        else if ((!bracket.empty()) && (element == '}') && (bracket.peek() != '{'))
            break; // *******Added this 'else if' block to support point no 1

        if ((!bracket.empty()) && (element == ']') && (bracket.peek() == '['))
            bracket.pop();
        else if ((!bracket.empty()) && (element == ']') && (bracket.peek() != '['))
            break; // *******Added this 'else if' block to support point no 1

        if ((!bracket.empty()) && (element == ')') && (bracket.peek() == '('))
            bracket.pop();
        else if ((!bracket.empty()) && (element == ')') && (bracket.peek() != '('))
            break; // *******Added this 'else if' block to support point no 1

        System.out.println(bracket);
    }
    if (bracket.empty())
        decision = "YES";
    else
        decision = "NO";
    System.out.println(bracket);

    return decision;
}