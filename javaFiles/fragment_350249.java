String command = "Hey tell [USER] to [ACTION]";
    String input = "Hey tell Player to come see me";
    String[] userInputArray = new String[2];

    String patternTemplate = command.replace("[USER]", "(.*)"); 
    patternTemplate = patternTemplate.replace("[ACTION]", "(.*)");

    Pattern pattern = Pattern.compile(patternTemplate);
    Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            userInputArray[0] = matcher.group(1);
            userInputArray[1] = matcher.group(2);

        }