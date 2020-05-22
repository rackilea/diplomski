import java.util.*;

public class ReplaceMapEntryValue {

    public static final void main(String[] args) {
        Map m;
        Iterator<Map.Entry> it;
        Map.Entry entry;

        // Create
        m = new HashMap();
        m.put("a", "alpha");
        m.put("b", "beta");

        // Update
        it = m.entrySet().iterator();
        while (it.hasNext()) {
            entry = it.next();
            if (entry.getKey() == "b") {
                entry.setValue("bravo");
            }
        }

        // Show
        it = m.entrySet().iterator();
        while (it.hasNext()) {
            entry = it.next();
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

        // Done
        System.exit(0);
    }
}