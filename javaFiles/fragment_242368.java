public static TreeMap<Integer, Double> SortByValue(Map<Integer, Double> map) {
        ValueComparator vc =  new ValueComparator(map);
        TreeMap<Integer, Double> sortedMap = new TreeMap<Integer, Double>(vc);\\constructor should be vc which extends Comparator
        sortedMap.putAll(map); 
        return sortedMap;
    }

class ValueComparator implements Comparator<Integer> {

    Map<Integer, Double> map;

    public ValueComparator(Map<Integer, Double> base) {
        this.map = base;
    }

    @Override
    public int compare(Integer a, Integer b) {
        // TODO Auto-generated method stub
        if (map.get(a) >= map.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}