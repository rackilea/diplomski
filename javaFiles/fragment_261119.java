String text = "Here    is a test";

    Pattern pattern = Pattern.compile("(?<=\\w)(\\s+)");

    Matcher matcher = pattern.matcher(text);
    if (matcher.find()) {
        System.out.println("number of whitespaces = " + matcher.group().length());

    }