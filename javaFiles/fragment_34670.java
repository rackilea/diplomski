import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args){
        String[] strings = {"foo 11 25","foo 67 45 97",
        "foo 38 15 976 24"};

        for(String string : strings) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            Matcher matcher = Pattern.compile("[a-z]+\\s(\\d+)\\s(\\d+)\\s?(\\d+)?\\s?(\\d+)?").matcher(string);
            matcher.find();
            for(int i = 0; i < 4; i++){
                if(matcher.group(i+1) != null) {
                     numbers.add(Integer.valueOf(matcher.group(i + 1)));
                }else{
                    System.out.println("group " + (i+1) + " is " + matcher.group(i+1));
                }
            }
            System.out.println("Match from string: "+ "\""+ string + "\"" + " : " + numbers.toString());
        }
    }
}