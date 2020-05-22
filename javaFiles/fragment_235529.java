private static class StackItem {

    public StackItem(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }

    public String prefix;
    public String number;
}

public List<String> encodings(String number) {
    List<String> results = new ArrayList<>();
    Stack<StackItem> stack = new Stack<>();
    stack.push(new StackItem("", number));
    while (!stack.isEmpty()) {
        StackItem current = stack.pop();
        if (current.number.equals("")) {
            results.add(current.prefix);
        } else {
            addToStackTakingNChars(2, current, stack);
            addToStackTakingNChars(1, current, stack);
        }
    }
    return results;
}

private void addToStackTakingNChars(int n, StackItem current, Stack<StackItem> stack) {
    if (current.number.length() >= n) {
        char c = parseChars(current.number, n);
        if (c >= 'A' && c <= 'Z') {
            stack.push(new StackItem(current.prefix + c, current.number.substring(n)));
        }
    }
}