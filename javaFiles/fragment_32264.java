import java.util.*;
class Test {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("924911637601767", Arrays.asList("1", "John"));
        map.put("864467483673342", Arrays.asList("2", "Paul"));
        map.put("825398867568656", Arrays.asList("8", "James"));
        map.put("1034643283235161", Arrays.asList("5", "Elina"));

        List<Map.Entry<String,List<String>>> entries = new ArrayList<Map.Entry<String,List<String>>>(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String,List<String>>>() {
            public int compare(Map.Entry<String,List<String>> l1, Map.Entry<String,List<String>> l2) {
                return l1.getValue().get(0).compareTo(l2.getValue().get(0));
            }
        });

        for (Map.Entry<String,List<String>> e : entries) {
            System.out.println(e.getKey() + " : [" + e.getValue().get(0)
                                          + ", " + e.getValue().get(1) + "]");
        }
    }
}