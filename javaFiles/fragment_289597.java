import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class UnmodifiableMapStackOverflowComplex
{
    public static void main(String[] args)
    {
        UnmodifiableMapStackOverflowComplex c = 
            new UnmodifiableMapStackOverflowComplex();

        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("X", "Y");
        c.setMap(map);

        for (int i=0; i<100000; i++)
        {
            Map<String, String> m = c.getMap();
            System.out.println("At "+i+": "+m.get("X"));
            c.setMap(m);
        }
    }

    private Map<String, String> map;
    Map<String, String> getMap()
    {
        // It's a good practice to only return unmodifiable VIEWS
        // on internal data structures:
        return Collections.unmodifiableMap(map);        
    }
    void setMap(Map<String, String> map)
    {
        this.map = map;
    }


}