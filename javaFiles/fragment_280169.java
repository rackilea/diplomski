public static List<String> methodCalls(String input) {
    List<String> matches = new ArrayList<>();

    Pattern p = Pattern.compile("\\s*[A-Za-z_]\\w*\\s*\\(");
    Matcher m = p.matcher(input);
    while (m.find()) {
        int start = m.start();
        int end = m.end();

        if (start == 3 && input.startsWith("new") 
            || start > 3 && input.substring(start-4, start).matches("\\Wnew")) {
            // if it is preceded by the word new, it is not a method call
            continue;
        }

        int pairs = 1;
        while (end < input.length() && pairs > 0) {
            // can't just stop at the next ')'
            // since parentheses may be nested
            char c = input.charAt(end);
            if (c == '(') pairs++;
            else if (c == ')') pairs--;
            end++;
        }

        matches.add(input.substring(start, end));
    }

    return matches;
}