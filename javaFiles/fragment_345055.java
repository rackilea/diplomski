class Pojo {

    private static final int MAX_SIZE = 5;

    private TreeMap<Integer, Map<String, String>> yearsMap = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer value1, Integer value2) {
            return value2.compareTo(value1);
        };
    });

    @JsonAnySetter
    public void setMonthFromLastYear(String year, Map<String, String> value) {
        Integer currentYear = Integer.valueOf(year);
        if (yearsMap.size() <= MAX_SIZE) {
            yearsMap.put(currentYear, value);
        } else if (currentYear > yearsMap.lastKey()) {
            yearsMap.remove(yearsMap.lastKey());
            yearsMap.put(currentYear, value);
        }
    }

    public Map<String, String> getValuesForYear(int year) {
        return yearsMap.get(year);
    }

    @Override
    public String toString() {
        return String.valueOf(yearsMap);
    }
}