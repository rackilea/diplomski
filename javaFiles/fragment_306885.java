{
    Pattern pattern = Pattern.compile("([\"'])((?:(?=(\\\\?))\\3.)*?)\\1");
    Matcher matcher = pattern.matcher(" HYPERLINK \"hyperlink_funda.docx\" \\l \"Sales\" ");

    while (matcher.find())
        System.out.println(matcher.group(2));
}