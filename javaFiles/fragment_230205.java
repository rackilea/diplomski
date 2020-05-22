// gradle: 'org.apache.commons:commons-lang3:3.3.2'
import org.apache.commons.lang3.StringEscapeUtils;

String s = serviceThatSometimesReturnsQuotedStringWithinString();
String usable = null;
if (s.length() > 0 && s.charAt(0) == '"' && s.charAt(s.length()-1) == '"') {
  usable = StringEscapeUtils.unescapeEcmaScript(s.substring(1, s.length()-1));
} else {
  usable = s;
}