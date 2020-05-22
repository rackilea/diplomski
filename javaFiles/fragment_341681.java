public static void main(String[] args) {
    List<Map<String, ?>> jsonList = new ArrayList<>();

    Map<String, String> mapOne = new HashMap<String, String>();

    mapOne.put("id", String.valueOf(66));
    mapOne.put("area", "Some Area");

    jsonList.add(mapOne);

    jsonList.forEach(map -> {
        map.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    });
}