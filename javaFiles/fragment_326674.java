public static void main(String[] args) {
    Map<String, String> map = new HashMap<String, String>();
    map.put("C", "D");
    map.put("B", "C");
    map.put("A", "E");
    map.put("D", "A");
    printMap(map);
}

public static void printMap(Map<String, String> mp) {
    LinkedList<String> ll = new LinkedList<String>();
    Iterator it = mp.entrySet().iterator();

    String keyStart = "B";
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        String key = (String) pair.getKey();
        if (!key.equals(keyStart)) {
            continue;
        }else{
            ll.add((String) pair.getValue());
            it.remove();
        }
    }
    Iterator it2 = mp.entrySet().iterator();
    while (it2.hasNext()) {
        Map.Entry pair = (Map.Entry)it2.next();
        String key = (String) pair.getKey();
        ll.add((String) pair.getValue());
        it2.remove();
    }
    System.out.println(ll);
}