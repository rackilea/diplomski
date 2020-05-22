import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Ideone
{
    private static String[] sentence_to_array;
    public static void main (String[] args) throws java.lang.Exception
    {
        String sentence = "The ball is round";
        Pattern p = null;
        Matcher m = null;
        System.out.println(findings(p, m, sentence, regex()));
    }
    private static List<String> findings(Pattern p, Matcher m, String pieces, String fr) {
        p = Pattern.compile(fr);
        m = p.matcher(pieces);
        List<String> lst = new ArrayList<>();
        while (m.find()) {
            lst.add(m.group());
        }//for
        return lst;
    }//method
    public static String first_regex() {
        return "(The|or|what)";
    }//Method
    public static String second_regex() {
        return "(Peter|Luke|Hans|ball)";
    }//method
    public static String regex() {//επιστρέφει το υποκείμενο ως regex
        return "(" + first_regex() + " " + second_regex() + ")";
    }//method
}