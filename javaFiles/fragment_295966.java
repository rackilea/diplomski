import java.util.regex.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        List < String > allMatches = new ArrayList < String > ();
        Matcher m = Pattern.compile("\\(([^)]*)\\)")
            .matcher("(192.168.0.112)(192.168.0.166)(192.168.0.112)(192.168.0.166)(192.168.0.106)");

        while (m.find())
            allMatches.add(m.group(1));

        for (String match: allMatches)
            myFunction(match);
    }

    public static void myFunction(String string) {
        System.out.println("got string " + string + " for further processing.");
        //do your processing here
    }
}