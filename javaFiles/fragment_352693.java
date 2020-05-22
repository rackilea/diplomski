private boolean isSubStack(java.util.Stack<Integer> s1, java.util.Stack<Integer> s2) {
    while (!s1.isEmpty() && !s2.isEmpty()) {
        while (!s1.isEmpty() && s1.peek() != s2.peek()) {
            s1.pop();
        }
        java.util.Stack<Integer> s3 = new java.util.Stack<Integer>();
        while (!s1.isEmpty() && !s2.isEmpty() && s2.peek().equals(s1.peek())) {
            s1.pop();
            s3.push(s2.pop());
        }
        if (!s2.isEmpty()) {
            while (!s3.isEmpty()) {
                s2.push(s3.pop());
            }
        }
    }
    return s2.isEmpty();
}