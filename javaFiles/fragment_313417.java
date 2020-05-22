import java.util.HashMap;
import java.util.Map.Entry;
public class Encrypt {

/**
 * @param args
 */
static HashMap<String, String> hm = new HashMap();

public static void main(String[] args) {
    // TODO Auto-generated method stub
    hm.put("a", "b");   
    hm.put("b", "c");   
    hm.put("c", "d");   
    hm.put("d", "e");   
    hm.put("e", "f");   
    hm.put("f", "g");
    hm.put("g", "h");   
    hm.put("h", "i");   
    hm.put("i", "j");   
    hm.put("j", "k");   
    hm.put("k", "l");   
    hm.put("l", "m");
    hm.put("m", "n");   
    hm.put("1", "4");   
    hm.put("2", "3");   
    hm.put("3", "2");   
    hm.put("4", "1");   
    hm.put("5", "0");

    String input = "this is a simple text";
    String text = encode(input);
    System.out.println(text);
    System.out.println(decode(text));

}

private static String decode(String input) {
    // TODO Auto-generated method stub
    StringBuffer output = new StringBuffer();
    for(int i = 0; i < input.length(); i++)
    {
        String ch = input.charAt(i)+"";
        if(hm.containsValue(ch))
        {
            for (Entry<String, String> entry : hm.entrySet()) {
                if (entry.getValue().equals(ch)) {
                    output.append(entry.getKey());
                }
            }
        }
        else
        {
            output.append(ch);
        }
    }
    return output.toString();
}

private static String encode(String input) {
    // TODO Auto-generated method stub
    StringBuffer output = new StringBuffer();
    for(int i = 0; i < input.length(); i++)
    {
        String ch = input.charAt(i)+"";
        if(hm.containsKey(ch))
        {
            output.append(hm.get(ch));
        }
        else
        {
            output.append(ch);
        }
    }
    return output.toString();
}