import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Module1{
    public static void main(String[] asd){
        String sourcestring = "1 NAME john smith";
        Pattern re = Pattern.compile("(\\d+)\\s+(NAME|@\\w+@)(.*)");
        Matcher m = re.matcher(sourcestring);
        int i = 0;
        while (m.find()){
            for( int groupIdx = 0; groupIdx < m.groupCount()+1; groupIdx++ ){
                System.out.println( "[" + i + "][" + groupIdx + "] = " + m.group(groupIdx));
            }
            i++;
        }
    }
}