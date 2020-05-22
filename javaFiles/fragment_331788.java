import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tie {

    public static void main(String agrs[]){
        Tie tie = new Tie();
        String fr = "4544FF";
        char[] strings = fr.toCharArray();
        List<Integer>integers = new ArrayList<Integer>();
        for(int i=0;i<strings.length;i++){
            if(tie.validationNumber(strings[i]+"")){
                integers.add(Integer.parseInt(strings[i]+""));
            }
        }
        for(Integer i:integers){
            System.out.println(i);
        }
    }

    public boolean validationNumber(String s){

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(s);

        if (matcher.matches()) {
            return true;
        }
        return false;   
    }
}