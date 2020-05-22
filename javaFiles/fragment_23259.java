/* Converts a list of records to a map. Uses element at index 0 as the key */
private static Map<String, String[]> toMap(List<String[]> records) {
    HashMap<String, String[]> map = new HashMap<String, String[]>();
    for (String[] row : records) {
        //column 0 will always have an ID.
        map.put(row[0], row);
    }
    return map;
}