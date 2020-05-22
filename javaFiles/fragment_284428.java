Pattern titleText = Pattern.compile("<title>(.*?)</title>");
String input = "<title>random text [[A]] more random text [[B]] ...</title>";
String text = "";

Matcher m = titleText.matcher(input);
if (m.find( )) {
    text = m.group(1);
}

String[] parts = text.split("\\[\\[");

for (int i=1; i < parts.length; ++i) {
    int index = parts[i].indexOf("]]");
    String match = parts[i].substring(0, index);
    System.out.println("Found a match: " + match);
}