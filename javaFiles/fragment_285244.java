private static class Target extends HashMap<String, String> {
}

public static void main(String[] args) {
    final Moshi build = new Moshi.Builder().build();
    final JsonAdapter<Map> adapter = build.adapter(Map.class);
    final Target value = new Target();
    value.put("foo", "bar");
    System.out.println(adapter.toJson(value));
}