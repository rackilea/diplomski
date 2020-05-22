Collections.sort(list, new Comparator<Map<String, String>>() {
    @Override
    public int compare(Map<String, String> map1,
             Map<String, String> map2) {
        String val1 = "";
        String val2 = "";
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            val1 = entry.getKey();
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            val2 = entry.getKey();
        }

        return Integer.valueOf(val1).compareTo(Integer.valueOf(val2));
    }
});