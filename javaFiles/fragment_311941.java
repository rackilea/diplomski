public static void reverseString(final String str) {
    final Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
        final char c = str.charAt(i);
        if (c == ' ') {
            while (!stack.isEmpty())
                System.out.print(stack.pop());
            System.out.print(' ');
        } else
            stack.push(c);
    }
    while (!stack.isEmpty())
        System.out.print(stack.pop());
}