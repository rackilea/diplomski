import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class together {
    private static Collection<people.family> familyList = new ArrayList<people.family>();
    public static ConcurrentMap<String, Collection<? extends people>> registry = new ConcurrentHashMap<String, Collection<? extends people>>();

    static {
        registry.put(people.family.class.toString(), familyList);
    }

}