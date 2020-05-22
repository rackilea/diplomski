// matches either a "quoted string" or a single word, both followed by any amount of whitespace
    Pattern argumentPattern = Pattern.compile("(\"([^\"]|\\\")*\"|\\S+)\\s*");

    // loop over all arguments
    Matcher m = argumentPattern.matcher(to2);
    for (int start = 0; m.find(start); start = m.end()) {

        // get a single argument and remove whitespace around it
        String argument = m.group(1).trim();

        // handle quoted arguments - remove outer quotes and unescape inner ones
        if (argument.startsWith("\""))
            argument = argument.substring(1,  argument.length() - 1).replace("\\\"", "\"");

        // ... your code that uses the argument here

    }