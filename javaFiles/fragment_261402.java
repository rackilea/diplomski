response = categoriesByProduct.entrySet()
                              .stream()
                              .map(e -> toMap(e))
                              .collect(Collectors.toList());

public static Map<String, Object> toMap(Map.Entry<Integer, List<Integer>> en) {
    Map<String,Object> responseObject = new HashMap<>();
    responseObject.put("pid", en.getKey());
    responseObject.put("categories",en.getValue());
    return responseObject;
}