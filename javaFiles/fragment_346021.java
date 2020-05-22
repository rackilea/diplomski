public static void main(String[] args) {
    // Map<String,Set<String>> dep = new HashMap<String,Set<String>>();
    MultiHashMap mp = new MultiHashMap();
    mp.put("a", "10");
    mp.put("a", "12");
    mp.put("a", "11");
    mp.put("b", "1");
    mp.put("c", "14");
    mp.put("e", "");
    mp.put("b", "1");
    mp.put("b", "2");
    mp.put("b", "3");
    List list = null;

    Set set = mp.entrySet();
    Iterator i = set.iterator();
    while (i.hasNext()) {

        Map.Entry<String, List<String>> me = (Map.Entry) i.next();

        for(int j = 0 ; j< me.getValue().size(); j++ )
        {
            System.out.println(me.getKey() +" : " +me.getValue().get(j));
        }
    }
}