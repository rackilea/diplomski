import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HelloWorld{

     public static void main(String []args){
        Pattern pattern = Pattern.compile("([a-zA-Z0-9']*)?([^a-zA-Z0-9']*)?");
        String str = "abc3a de'f gHi?jk";
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            if(matcher.group(1).length() > 0)
                System.out.println("Match:" + matcher.group(1));
            if(matcher.group(2).length() > 0)
                System.out.println("Miss: `" + matcher.group(2) + "`");
        }
     }
}