private static Map<String, String> createMap(String name, String phone, String shipping) {
    Map<String, String> map = new HashMap<>(3);
    map.put("name", name);
    map.put("phone", phone);
    map.put("shipping", shipping);
    return map;
}