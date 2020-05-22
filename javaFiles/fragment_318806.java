import java.util.*;
import java.io.*;
import java.util.regex.*;
import java.util.List;

class Program {
public static void main (String[] args) throws java.lang.Exception  {

String subject = "code_numbers = '123_456'";
Pattern regex = Pattern.compile("'[^']*'|(_)");
Matcher m = regex.matcher(subject);
StringBuffer b= new StringBuffer();
while (m.find()) {
    if(m.group(1) != null) m.appendReplacement(b, " ");
    else m.appendReplacement(b, m.group(0));
}
m.appendTail(b);
String replaced = b.toString();
System.out.println(replaced);
} // end main
} // end Program