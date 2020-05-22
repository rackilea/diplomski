import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Untitled {
    public static void main(String[] args) {
        String replaced = replaceSemiColons("5;4;;;4;4;;;;4;;;3;;1;5;4;5;;3;5;;5;;5;3;;;;;;;;;;;;5;");
        replaced = replaced.replace(";", "");
        System.out.println(replaced);
    }

    public static String replaceSemiColons(String string) {
        StringBuffer replaced = new StringBuffer(string);
        Pattern pattern = Pattern.compile(";;+");
        Matcher matcher = pattern.matcher(replaced.toString());
        while(matcher.find()){
            replaced.replace(matcher.start(), matcher.end(), new String(new char[matcher.end() - matcher.start() - 1]).replace("\0", "0"));
            matcher = pattern.matcher(replaced.toString());
        }
        return replaced.toString();
    }
}