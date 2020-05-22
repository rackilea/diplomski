import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

....

static String formatMyString(String input){
    DecimalFormat myFormatter = new DecimalFormat("###,###.###");
    StringBuffer sb = new StringBuffer();
    Pattern p = Pattern.compile("(\\d+\\.*\\d+)");
    Matcher m = p.matcher(input);
    while(m.find()){
        String rep = myFormatter.format(Double.parseDouble(m.group()));
        m.appendReplacement(sb,rep);            
    }
    m.appendTail(sb);
    return sb.toString();
}