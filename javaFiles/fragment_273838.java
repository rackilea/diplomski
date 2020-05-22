Pattern pattern = Pattern.compile("#([0-9A-Fa-f]{2})\\1\\1");
String css = "#abcdef #7C7C7C #001122";

Matcher matcher = pattern.matcher(css);
if (matcher.find())
    System.out.println(matcher.group());