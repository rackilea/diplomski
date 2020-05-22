public static boolean isValid(String str) {
    Stack<Character> stack = new Stack<>();
    for (char c : str.toCharArray()) {
        switch (c) {
            case '{':
                stack.push(c);
                break;
            case '}':
                if (stack.isEmpty()) {
                    return false;
                }
                Character last1 = stack.pop();
                if (last1 != '{') {
                    return false;
                }
                break;
            case '\"':
                if (stack.isEmpty()) {
                    return false;
                }
                Character last2 = stack.peek();
                if (last2 == '\"') {
                    // It's a closing quote
                    stack.pop();
                } else {
                    // It's an opening quote
                    stack.push(c);
                }
                break;
        }
    }
    return stack.isEmpty();
}