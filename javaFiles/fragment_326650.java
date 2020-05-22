int startIndex = message.indexOf("https://twitter.com/");
int endIndex = message.indexOf(" ", startIndex);
if (endIndex == -1) {
    endIndex = message.length();
}
String link = message.substring(startIndex, endIndex);