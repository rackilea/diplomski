import java.util.HashMap;

public class HelloWorld{

     public static void main(String []args){
        HashMap<String, String> holder = new HashMap();
        String payload = "cossn=0, abc=hello/=world";
        String[] keyVals = payload.split(", ");
        for(String keyVal:keyVals)
        {
          String[] parts = keyVal.split("=",2);
          holder.put(parts[0],parts[1]);
        }

     }
}