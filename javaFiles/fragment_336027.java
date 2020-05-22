static class ValueComparator implements Comparator<String> {

    Map<String, Integer> base;

    ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    @Override
    public int compare(String a, String b) {
        Integer x = base.get(a);
        Integer y = base.get(b);
        if (x.equals(y)) {
            return a.compareTo(b);
        }
        return x.compareTo(y);
    }
}


HashMap<String, Integer> map = new HashMap<String, Integer>();
ValueComparator vc = new ValueComparator(map);
TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(vc);

map.put("z",30);
map.put("e",10);
map.put("b",20);
map.put("c",20);

sorted.putAll(map);

for (String key : sorted.keySet()) {
    System.out.println(key + " : " + sorted.get(key)); 
}