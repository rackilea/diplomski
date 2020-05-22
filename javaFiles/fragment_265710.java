import java.util.regex.Matcher;
import java.util.regex.Pattern;

String regex = "^bamos\\/openface\\h+latest\\h+([a-z0-9]+)";
String string = "bamos/openface       latest       62d1673065e8       12 weeks ago       1.941 GB\n"
     + "other/repository       latest       22d1673065e8       12 weeks ago       1.941 GB\n"
     + "bamos/openface       previous       77d1673065e8       12 weeks ago       1.941 GB";

Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
Matcher matcher = pattern.matcher(string);

while (matcher.find())
    System.out.println(matcher.group(1));