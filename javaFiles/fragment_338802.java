String input = "- - - [DA/MM/YEAR:HH:MM:SEC +0000] \"GET / HTTP/1.1\" \"/somepath.../index.html\" 111 123 \"-\" \"-\" 9792 0 11.112.1.112->11.112.1.121 231xx";

Pattern pattern = Pattern.compile("\\[([^\\]]*)\\]\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)\\s+(\\d+)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)\\s+(\\d+)\\s+([^\\s+]*)\\s+(.*)");
Matcher matcher = pattern.matcher(input);
if (matcher.find()) {
    System.out.println(matcher.group(0));
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
    System.out.println(matcher.group(3));
    System.out.println(matcher.group(4));
    System.out.println(matcher.group(5));
    System.out.println(matcher.group(6));
    System.out.println(matcher.group(7));
    System.out.println(matcher.group(8));
    System.out.println(matcher.group(9));
    System.out.println(matcher.group(10));
    System.out.println(matcher.group(11));
 }