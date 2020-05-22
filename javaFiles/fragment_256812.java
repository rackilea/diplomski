public static void main(String[] args) {
    Contains lib = new Contains("lib");
    Contains room = new Contains("room");
    Contains bookshelf = new Contains("bookshelf");
    Contains shelf = new Contains("shelf");

    bookshelf.add(shelf);
    room.add(bookshelf);
    lib.add(room);

    // Option 1
    System.out.println(setupLib(lib).toJSONString());

    // Option 2
    Gson gson = new Gson();
    System.out.println(gson.toJson(lib));
}

private static JSONObject setupLib(Contains contain) {
    if (contain == null) return null;
    LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

    JSONArray array = new JSONArray();
    for (Contains c : contain.getContainerList()) {
        JSONObject innerContain = setupLib(c);
        if (innerContain != null) {
            array.add(innerContain);
        }
    }
    map.put("name", contain.getName());
    map.put("contains", array);

    return new JSONObject(map);
}