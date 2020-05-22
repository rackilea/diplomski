import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableMapStackOverflow
{
    public static void main(String[] args)
    {
        int depth = 20000; 
        test(depth);
    }

    private static void test(int depth)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("X", "Y");
        for (int i =0; i<depth; i++)
        {
            map = Collections.unmodifiableMap(map);
        }
        String value = map.get("X");
        System.out.println("At "+depth+" got "+value);
    }
}