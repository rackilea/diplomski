import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class HelloWorld{

     public static void main(String []args){
        String url = "http://domainName/contentid/controller_hscc.jsp?q=1" ;
        //String url = "baaaaab" ;
        String regex = "^.*?controller(\\w+)?\\.jsp.*?$" ;

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(url);
        boolean retVal = Pattern.matches(regex, url) ;
        System.out.println(m.matches() + "__" + retVal);
     }
}