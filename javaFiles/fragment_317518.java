import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "^\\/src\\/main\\/java(\\/[^\\/]+)\\/\\*\\.java$";
final String string = "/src/main/java/{any_package}/*.java\n"
     + "/src/main/java/*.java";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}