TreeMap<String, Integer> treemap = new TreeMap<String, Integer>(new Comparator<String>() {
    public int compare(String o1, String o2) {
        return o1.toLowerCase().compareTo(o2.toLowerCase());
    }
});
treemap.put("Lol", 1);
treemap.put("Marc", 2);
treemap.put("Jesper", 3);
treemap.put("lol1", 1);
treemap.put("marc1", 2);
treemap.put("jesper1", 3);