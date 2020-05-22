import java.text.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        String text = "Thu, 1 Mar 2012 13:57:06 -0600";
        // Note the explicit locale. Let's not leave it as the system default :)
        DateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z", 
                                                    Locale.US);

        Date dt = formatter.parse(text);
        System.out.println(dt);
    }
}