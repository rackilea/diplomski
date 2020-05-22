import java.util.*;

class SortMapValues {
    public static boolean ASC = true;
    public static boolean DESC = false;

    public static void main(String[] args) {
        // Creating dummy unsorted map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 3);
        map.put(2, 2);
        map.put(3, 4);

        Map<Integer, Integer> sortedMapDesc = sortByComparator(map, DESC);
        printMap(sortedMapDesc);

    }

    private static Map<Integer, Integer> sortByComparator(Map<Integer, Integer> map, final boolean order) {
        List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(map.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
            public int compare(Entry<Integer, Integer> o1,
                    Entry<Integer, Integer> o2) {
                if (order) {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static void printMap(Map<Integer, Integer> map) {
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
        }
    }
}