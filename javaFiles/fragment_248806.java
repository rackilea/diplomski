import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "^(.*?)=\\K(\\s*([0-9]{6})\\s*[;,])+\\s*$";
final String string = "input1=444554; 445148, 414121;\n"
     + "input1=444554; 445148, 41412;\n"
     + "input2=414454, \n"
     + "input1=444554; 44514, 414121;\n"
     + "input1=444554; 445141, 414121; 414121\n"
     + "input2:414454, ";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}