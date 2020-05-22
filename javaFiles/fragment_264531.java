import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "some.text.here only but not Some other " + 
                "there some.name.separated.by.dots and.we are done!";
        Pattern p = Pattern.compile("\\w+(\\.\\w+)+");
        Matcher m = p.matcher(text);
        while(m.find()) {
            System.out.println(m.group());
        }
    }
}