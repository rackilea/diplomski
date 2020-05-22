import java.util.*;

public class TMap {
    private TreeMap<String, Integer> St;
    private int num_atrib = 6;

    public TMap() {
        St = new TreeMap<String, Integer>();
    }

    public Set<String> getKeySet() {
        return St.keySet();
    }

    public Integer get(String s) {
        return St.get(s);
    }

    public static TreeMap<String, Integer> Station(String s,int i) {
        St.put(s,i);
        System.out.println("Now the tree map Keys: " + St.keySet());
        System.out.println("Now the tree map contain: " + St.values());
        return St;
    }
}