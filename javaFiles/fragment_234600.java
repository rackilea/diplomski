String input = "<!-- \nto be removed -->hello <!-- to be removed-->world";
    Pattern pattern = Pattern.compile("<!--.*?-->", Pattern.DOTALL | Pattern.UNICODE_CASE | Pattern.MULTILINE);
    Matcher matcher = pattern.matcher(input);
    StringBuilder builder = new StringBuilder();
    int lastIndex = 0;
    while (matcher.find()) {
        builder.append(input.substring(lastIndex, matcher.start()));
        lastIndex = matcher.end();
    }
    builder.append(input.substring(lastIndex));
    System.out.println(builder);