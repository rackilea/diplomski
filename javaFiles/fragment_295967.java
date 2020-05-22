import java.util.regex.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        int index=0;
        Map<Integer, String> allMatches = new HashMap<Integer, String> ();
        Matcher m = Pattern.compile("\\(([^)]*)\\)")
            .matcher("(192.168.0.112)(192.168.0.166)(192.168.0.112)(192.168.0.166)(192.168.0.106)");

        while (m.find())
            allMatches.put(index++, m.group(1));

        for (Map.Entry<Integer, String> match: allMatches.entrySet())
            myFunction(match.getKey(), match.getValue());
    }

    public static void myFunction(int index, String ip) {
        System.out.println("Index: " + index + " - got string " + ip + " for further processing.");
        //do your processing here
    }
}