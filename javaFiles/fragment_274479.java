import java.util.ArrayList;
import java.util.List;


public class ListString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] str = new String[2];
        str[0] = "a";
        str[1] = "b";

        List<String[]> val = new ArrayList<String[]>();
        val.add(str);

        for(String[] s:val){
            for(int i=0;i<s.length;i++){
                System.out.println(s[i]);
            }
        }

    }

 }