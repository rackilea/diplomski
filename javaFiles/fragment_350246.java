String needle = "dog";
String regex = needle.replaceAll("(.(?!$))", "$1\n?"); // inserts line breaks
// regex now becomes "d\n?o\n?g"
Pattern p = Pattern.compile(regex);
Matcher matcher = p.matcher("cat do\ng cow");
if (matcher.find()) {
    int start = matcher.start();
    int end = matcher.end();
    System.out.println("Start: "+start+" End: "+end);
}
else
    System.err.println("No match available");