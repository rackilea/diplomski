import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Test {
    public static void main(String [] args){
        //This list is supposed filled with some values
        List<String> quotes = new ArrayList<String>();

        for(String quote:quotes){
            Pattern pattern = Pattern.compile(".*?<pre>(.*?)</pre>.*?");
            Matcher m = pattern.matcher(quote);
            while(m.find()){
                String result = m.group(1);
                System.out.println(result);
            }
        }


}