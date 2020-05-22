import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester {
    static ArrayList<String> listOfEnums;
    public static void main(String[] args) {
        listOfEnums = new ArrayList<String>();
        Pattern pattern = Pattern.compile("^\\([0-9a-zA-Z^]+\\)");
        String p = "(a) (1) (c) (xii) (A) (12) (ii) and the good news (1)";
        Matcher matcher = pattern.matcher(p);
        boolean isMatch = matcher.find();
        int index = 0;
        //once you find a match, remove it and store it in the arrayList. 
        while (isMatch) {
          String s = matcher.group();
          System.out.println(s);
          //Store it in an array
          listOfEnums.add(s);
          //Remove it from the beginning of the string.
          p = p.substring(listOfEnums.get(index).length(), p.length()).trim();
          matcher = pattern.matcher(p);
          isMatch = matcher.find();
          index++;
        }
    }
}