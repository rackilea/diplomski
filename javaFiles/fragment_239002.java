Map<Integer, Integer> map = new HashMap<Integer, Integer>();
for (Integer i : HoursList) {
    Integer count = map.get(i);
    map.put(i, count != null ? count+1 : 0);
}

Integer mostlySelectedhr = Collections.max(map.entrySet(),
    new Comparator<Map.Entry<Integer, Integer>>() {
    @Override
    public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
    }
}).getKey();