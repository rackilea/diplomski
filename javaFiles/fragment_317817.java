Pattern regEx = Pattern.compile("^(.*)(&lt;m&gt;)(.*)(&lt;xm&gt;)(.*)$", Pattern.MULTILINE);
Matcher matcher = regEx.matcher(content);
if (matcher.find()) { // calling find() is important
// if the regex matches multiple times, use while instead of if
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
    System.out.println(matcher.group(3));
    System.out.println(matcher.group(4));
    System.out.println(matcher.group(5));
} else {
    System.out.println("Regex didn't match");
}