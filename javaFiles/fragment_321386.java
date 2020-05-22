import java.util.regex.*;

String aParser="<con><status>OK</status><session>12312332432</session></con>";
Pattern p=Pattern.compile("<session>(.*)</session>");
Matcher m=p.matcher(aParser);

while(m.find())
{ 
   System.out.println(m.group(1));
}