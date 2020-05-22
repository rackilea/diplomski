String str =
        "some text\n"+
        "/*********\n" +
        "block of comments - line 1\n" +
        "line 2\n"+
        "....\n" +
        "***/\n" +
        "some more text";

    Pattern p = Pattern.compile("/\\*+(.*?)\\*+/", Pattern.DOTALL);
    Matcher m = p.matcher(str);

    if (m.find())
        System.out.println(m.group(1));