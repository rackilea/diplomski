String fulltext = "I would like to create some text and i dont know what creater34r3, ";
    String subtext = "create";
    Pattern pattern = Pattern.compile("\\b(" + subtext + ")\\b");
    Matcher matcher = pattern.matcher(fulltext);
    while (matcher.find()) {
        System.out.println(matcher.group());
    }