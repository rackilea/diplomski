public class ListSizeComparator implements Comparator<String> {

private final Map<String, List<String>> map;

public ListSizeComparator(final Map<String, List<String>> map) {
    this.map = map;
}

@Override
public int compare(String s1, String s2) {
    //Here I assume both keys exist in the map.
    List<String> list1 = this.map.get(s1);
    List<String> list2 = this.map.get(s2);
    Integer length1 = list1.size();
    Integer length2 = list2.size();
    return length1.compareTo(length2);
}

}