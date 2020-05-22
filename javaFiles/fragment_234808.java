public static void getTopTenWords(TreeMap<String, ArrayList<Integer>> map) {
    Set<Map.Entry<String, ArrayList<Integer>>> set = map.entrySet();

    TreeMap<Integer, String> temp = new TreeMap<Integer, String>();

    for(Map.Entry<String, ArrayList<Integer>> entry : set) {
        int size = entry.getValue().size();
        int word = entry.getKey();

        temp.put(new Integer(size), word));    
    }
}