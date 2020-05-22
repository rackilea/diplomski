import java.util.regex.Matcher;
import java.util.regex.Pattern;

String myString = "<root><child id=\"foo\">Bar</child></root>";

Matcher m = Pattern.compile("[^\\p{L}\\p{N};\"+*/-]").matcher(myString);

while (m.find()) {
    String found = m.group();
    myString = myString.replaceAll(found, "&#" + (int)found.charAt(0) + ";");
}

System.out.println(myString);