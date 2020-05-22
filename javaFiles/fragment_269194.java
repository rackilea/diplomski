import java.util.regex.Matcher;
 import java.util.regex.Pattern;

 ...

 List<String> allMatches = new ArrayList<String>();
 Matcher m = Pattern.compile("your regular expression here")
     .matcher(yourStringHere);
 while (m.find()) {
   allMatches.add(m.group());
 }