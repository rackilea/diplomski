public static boolean isBalanced(String inp) {
    Stack<Character> s = new Stack<>();
    for (char brackBrick : inp.toCharArray()) {
        switch (brackBrick) {
            case '{': s.push('}'); break;
            case '(': s.push(')'); break;
            case '[': s.push(']'); break;
            case ' ': break;
            default : if (s.isEmpty() || brackBrick != s.peek()) { return false;}
                s.pop();
        }
    }

    return s.isEmpty();
}