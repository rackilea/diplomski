public static void main(String[] args) {
    int u = 0;
    int v = 1;
    Map<Integer, ArrayList<Integer>> map = 
        new HashMap<Integer, ArrayList<Integer>>();
    if (map.get(u) == null) { // Add a List if they key is null.
        map.put(u, new ArrayList<Integer>());
    }
    // Add v to the List at u.
    map.get(u).add(v);
    System.out.println(map);
}