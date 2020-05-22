Map<Integer, Integer> count = new HashMap<>();
for (Integer value : list) {
    Integer temp = count.get(value);
    if (temp != null) {
        count.put(value, temp + 1);
    } else {
        count.put(value, map.getOrDefault(value, 0) + 1);
    }
}