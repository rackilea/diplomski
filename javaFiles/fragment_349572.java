public static Map<String, Object> summarizeData(List<String> lines) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (String line : lines) {
        String[] temp = line.split("\\s+");
        Integer total = map.get(temp[0]);
        total = total == null ? 0 : total;
        map.put(temp[0], total + Integer.valueOf(temp[1]));
    }
    return map;
}