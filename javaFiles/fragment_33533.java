import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "^(([a-z0-9\\s]+\\/)+)?([a-z0-9\\s]+)\\.[a-z]+";
final String string = "Documents/OneDrive/Collections/book.xlsx\n"
     + "Documents/OneDrive/Collections/book.xls\n"
     + "Documents/OneDrive/Collections/book.xlsm\n"
     + "book 2.xls\n"
     + "aa.xlsx\n\n";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}