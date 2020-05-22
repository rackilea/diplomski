private String reverse(String text) {
    final Stack<Character> stack = new Stack<>();
    for (int i = 0; i < text.length(); i++) {
        stack.push(text.charAt(i));
    }

    StringBuilder builder = new StringBuilder(text.length());
    for (int i = 0; i < text.length(); i++) {
        builder.append(stack.pop());
    }

    return builder.toString();
}