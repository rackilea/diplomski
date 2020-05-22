import java.util.ArrayList;
import java.util.HashMap;

public class MyHashMap<T extends Thing> {
    private HashMap<String, ArrayList<T>> map;

    public MyHashMap() {
        map = new HashMap<>();
    }

    public void add(String s, T element) {
        ArrayList<T> list = null;
        if ((list = map.get(s)) == null)
            map.put(s, list = new ArrayList<T>());
        list.add(element);
    }

    public ArrayList<T> get(String s) {
        return map.get(s);
    }
}