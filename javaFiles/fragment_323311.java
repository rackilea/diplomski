Random r = new Random(1234697890);
HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

for(int i=0;i<100000;i++){
    List<Integer> list = new ArrayList<Integer>();
    for(int j=0;j<1000;j++){
        list.add(r.nextInt(100000));
    }
    map.put(i, list);
    map.remove(i);
}