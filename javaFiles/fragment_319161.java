final static String DELIMITER = ",";
final static String PARENTHESES_START = "(";
final static String PARENTHESES_END = ")";

public static List<String> parseArguments(String text) {
    List<String> arguments = new ArrayList<>();
    StringBuilder argParsed = new StringBuilder();

    StringTokenizer st = new StringTokenizer(text, DELIMITER);
    while (st.hasMoreElements()) {
        // default: add next token
        String token = st.nextToken();
        System.out.println("Token: " + token);
        argParsed.append(token);

        // if token contains '(' we have
        // an expression or nested call as argument 
        if (token.contains(PARENTHESES_START)) {
            System.out.println("Nested expression with ( starting: " + token);

            // reconstruct to string-builder until ')'
            while(st.hasMoreElements() && !token.contains(PARENTHESES_END)) {
                // add eliminated/tokenized delimiter 
                argParsed.append(DELIMITER);

                // default: add next token
                token=st.nextToken();
                System.out.println("Token inside nested expression: " + token);
                argParsed.append(token);
            }
            System.out.println("Nested expression with ) ending: " + token);
        }

        // add complete argument and start fresh
        arguments.add(argParsed.toString());
        argParsed.setLength(0);
    }

    return arguments;
}