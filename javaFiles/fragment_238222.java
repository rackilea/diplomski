import java.util.HashMap;
import java.util.Map;

public class Parse{
    public static void main(String ...args){
        String agf = "abc*pqr$sfd*ghn$atr*mnb$tre*fgt";
        String [] split = agf.split("\\$");
        Map<String,String> map = new HashMap<String,String>();
        for(String temp : split){
            String [] tempo = temp.split("\\*");
            map.put(tempo[0],tempo[1]);
        }
        for(String mapkeys : map.keySet()){
            System.out.println(mapkeys+" ::: "+map.get(mapkeys));
        }
    }
}