import java.util.*;
public class Generic {
    static class Foo {};
    static Map<String, List<Foo>> x() {
        return null;
    }
    static Map<String, Collection<Foo>> y() {
        return null;
    }
    static Map<String, ? extends Collection<Foo>> myMap;
    public static void main(String[] args) {
        myMap = x();
        myMap = y();
        myMap = new HashMap<String,SortedSet<Foo>>();
        for (Collection<Foo> value : myMap.values());
    }
}