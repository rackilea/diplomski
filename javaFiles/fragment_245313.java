Collections.sort(arrayListHashMap, new Comparator<HashMap<String, String>>() {

    @Override
    public int compare(HashMap<String, String> m1, HashMap<String, String> m2) {
        return Integer.valueOf(m1.get("distance")).compareTo(Integer.valueOf(m2.get("distance")));
    }
});