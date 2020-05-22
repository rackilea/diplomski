public static boolean isBalanced(String input) {
    if (input == null)
        return false;
    int size = input.length();
    if (size % 2 == 1)
        return false;

    HashMap<Character, Character> map = new HashMap<>();
    map.put('(', ')');
    map.put('[', ']');
    map.put('{', '}');
    map.put('&', '&');

    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < size; i++) {
        Character temp = input.charAt(i); // autobox here so it only happens once
        if (temp.equals(stack.peek())) // equals is false if stack is empty, since peek returns null
            stack.pop();
        else if (map.containsKey(temp))
            stack.push(map.get(temp));
        else
            return false;
    }

    return stack.isEmpty();
}