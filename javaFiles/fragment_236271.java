import java.util.regex.*;

public class PatternExample {

    public static void main(String[] args) {
        String split = "The Lazy dog is running fast";
        Pattern pattern = Pattern.compile("(.*)(dog)(.*)");
        Matcher matcher = pattern.matcher(split);
        while (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++){
                System.out.println(i + "->" + matcher.group(i));
            }
        }
    }
}