import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        String source =
                "((-2, -1 ), ( 4, 2) ) ((-1.2, 0), (0, 0))  \n" +
                "((0, 0), (10, -1))                         \n" +
                "((5, 3), (5, 4)) ((5, 1) , (5, 5))         \n" +
                "((8, 3), (10, 3))                          \n" +
                "((8, 5), (11.5, 5))                        \n";

        Matcher m = Pattern.compile("-?\\d+(\\.\\d+)?").matcher(source);

        while(m.find()) {
            double value = Double.parseDouble(m.group());
            System.out.println("value=" + value);
        }
    }
}