String str = "blabla http://www.mywebsite.com blabla";
String regex = "((https?:\\/\\/)?(www.)?(([a-zA-Z0-9-]){2,}\\.){1,4}([a-zA-Z]){2,6}(\\/([a-zA-Z-_/.0-9#:+?%=&;,]*)?)?)";
Matcher m = Pattern.compile(regex).matcher(str);
if (m.find()) {
    String url = m.group(); //value "http://www.mywebsite.com"
}