import java.util.regex.Matcher;
import java.util.regex.Pattern;

 ...

String id;
String time;
String timeStamp;
String tick;
String url;

 ...

String textual = "<WebApicall id="4" time="2013-10-05; 22:44:18" timeStamp="|18|44|22|5|9|113|6|277|0|" tick="11589293" file="self" bdlLine="61" type="url" url="http://www.google.com/"> WebUrl </WebApicall>";
String regex = "^<WebApicall\\s+id=\\\"(\\d+)\\\"\\s+time=\\\"(.*)\\\"\\s+timeStamp=\\\"(\\|?\\d+\\|)+\\\"\\s+tick=\\\"(\\d+)\\\".*url=\\\"(.*)\\\">";
Matcher m = Pattern.compile(regex).matcher(textual);
if (m.matches()) {
  id = m.group(1);
  time = m.group(2);
  timeStamp = m.group(3);
  tick = m.group(4);
  url = m.group(5);
   ...
}
 ...