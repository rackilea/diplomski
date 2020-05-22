import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main { 
    public static void main(String[] args) {
        String text = "Some random text I don't care about"      + "\n" +
                ""                                               + "\n" +
                "The match starts at the beginning of this line" + "\n" +
                "The match continues across this line"           + "\n" +
                "The match stops here STOP more"                 + "\n" +
                "don't care about"                               + "\n" +
                ""                                               + "\n" +
                ""                                               + "\n" +
                ""                                               + "\n" +
                "foo"                                            + "\n" +
                "barSTOP"                                        + "\n" +
                "text I don't care about";
        Matcher m = Pattern.compile("(?ms)^[ \t]*+$\\s*+(?:(?!STOP).)*+").matcher(text);
        while(m.find()) {
            System.out.println("match ->"+m.group()+"<-");
        }
    }
}