class ValueComparator implements Comparator<String> {

    Map<String, Date> map;
    public ValueComparator(Map<String, Date> map) {
        this.map = map;
    }

    public int compare(String a, String b) {
        return map.get(a).compareTo(map.get(b));
    }
}