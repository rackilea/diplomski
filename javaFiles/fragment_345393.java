import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.*;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String s = "TABLE1\n=======\n1  | 2\n15 | 2\n3  | 15\n\nTABLE2\n=======\n3  | 5\n12 | 2\n17 | 7"; 
        Pattern pattern = Pattern.compile("(?<tabledata>\\S+)\\s+\\S+(?<vals>[|\\d\\s]+)");
        Matcher matcher = pattern.matcher(s);
        List<List<String>> res = new ArrayList<>();
        while (matcher.find()){
            List<String> lst = new ArrayList<>();
            if (matcher.group("tabledata") != null) {
                lst.add(matcher.group("tabledata"));
            }
            if (matcher.group("vals") != null) {
                Matcher m = Pattern.compile("\\d+").matcher(matcher.group("vals"));
                while (m.find()) {
                    lst.add(m.group(0));
                }
            }
            res.add(lst);
        } 
        System.out.println(res); 
    }
}