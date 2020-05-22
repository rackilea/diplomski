String value = "{'ID': '1', 'more': {'Key': 'Value', 'Object': {'Akey': 'Avalue'}}}";
    String delimiter = ", 'more'"; // pay attention to the comma, you can fix it by splitting by comma
    int start = value.indexOf(delimiter);
    System.out.println("start = " + start);
    Stack<Character> stack = new Stack<>();
    String substring = value.substring(start + delimiter.length(), value.length());
    System.out.println("substring = " + substring);
    char[] chars = substring.toCharArray();
    int end = 0;
    for (int i = 0; i < chars.length; i++) {
        char c = chars[i];
        if (c == '{')
            stack.push('{');
        if (c == '}') {
            stack.pop();
            if (stack.isEmpty()) {
                end = i;
                break;
            }
        }
    }
    System.out.println("end = " + end);
    String substring2 = value.substring(start, start + end + delimiter.length());
    System.out.println(substring2);
    System.out.println(value.replace(substring2, ""));