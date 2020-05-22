import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
public static final Pattern PATTERN = Pattern.compile("\\[\\s*\\*\\s*(.*?)\\s*?\\*\\s*\\]");

public static List<String> parse(String fileContent) {
    Matcher matcher = PATTERN.matcher(fileContent);
    List<String> foundData = new ArrayList<>();
    while (matcher.find()) {
        foundData.add(matcher.group(1));
    }
    return foundData;
}

public static void printOutList(List<? extends CharSequence> list) {
    list.forEach(System.out::println);
}

public static void main(String[] args) {
    printOutList(parse("[ this will not match ] [ * YOU WILL BE MATCHED!!!11 * ] [* you as well *] [*you too*]" +
            " [           *              this as well       *] [this * will * not]"));
}
}