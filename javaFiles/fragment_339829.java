public static boolean isValid(String s) {
    System.out.println(s);
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (ch == '(' || ch == '{' || ch == '[') {
            st.push(ch);
        } else if (ch == ')' || ch == '}' || ch == ']') {
            if (st.isEmpty()) {
                return false;
            }
            char topChar = st.pop();
            if (ch == ')' && topChar != '(') {
                return false;
            }
            if (ch == '}' && topChar != '{') {
                return false;
            }
            if (ch == ']' && topChar != '[') {
                return false;
            }
        }
    }
    return st.isEmpty();
}