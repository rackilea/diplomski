// text for 1st pattern
String text1 = "v1.0 - 80 s200 + 2013-10-17T05:59:59-0700 1TZY6R5HERP7SJRRYDYV 69.71.202.109 7802 41587 495307 30595 HTTP/1.1 POST /gp/ppd";
// text for 2nd pattern
String text2 = "access-1080.2013-10-17-05.us-online-cpp-portlet-live-1d-i-752c3b12.us-east-1.phnew.com.gz";
// 1st pattern - note that the "word" boundary separators are useless here, 
// but they might come in handy if you had alphanumeric Strings longer than 20 characters
Pattern accessIdPattern = Pattern.compile("\\b[A-Z0-9]{20}\\b");
Matcher m = accessIdPattern.matcher(text1);
while (m.find()) {
    System.out.println(m.group());
}
// this is trickier. I assume for your 2nd pattern you want something delimited on the
// left by a dot and starting with 2 lowercase characters, followed by a hyphen, 
// followed by a number of alnums, followed by ".com"
Pattern otherThingie = Pattern.compile("(?<=\\.)[a-z]{2}-[a-z0-9\\-.]+\\.com");
m = otherThingie.matcher(text2);
while (m.find()) {
    System.out.println(m.group());
}