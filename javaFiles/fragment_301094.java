//Format:
//ID: [WARNING|ERROR|DEBUG] Message...
String testLine = "5AB729: WARNING Some really really really long message";

Matcher matcher = Pattern.compile("([A-Z0-9]*): WARNING.*").matcher(testLine);
if ( matcher.matches() ) {
    String id = matcher.group(1);
        //...do something with id...
}