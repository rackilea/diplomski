import java.util.SortedSet;
import java.util.TreeSet;

public class SortMapOnKeyAndValue {

    public static void main(String[] args) {
        SortedSet<KeyValuePair> sortedSet = new TreeSet<KeyValuePair>();
        sortedSet.add(new KeyValuePair(1, 2));
        sortedSet.add(new KeyValuePair(2, 2));
        sortedSet.add(new KeyValuePair(1, 3));
        sortedSet.add(new KeyValuePair(2, 1));

        for (KeyValuePair keyValuePair : sortedSet) {
            System.out.println(keyValuePair.key+","+keyValuePair.value);
        }
    }
}
class KeyValuePair implements Comparable<KeyValuePair>{
    int key, value;

    public KeyValuePair(int key, int value) {
        super();
        this.key = key;
        this.value = value;
    }

    public int compareTo(KeyValuePair o) {
        return key==o.key?value-o.value:key-o.key;
    }
}