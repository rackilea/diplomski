public void testMapConstructor() {
  /* Test with non-empty Map. */
  Map<String, String> map = ImmutableMap.of(
      "canada", "dollar",
      "chile", "peso",
      "switzerland", "franc");
  HashBiMap<String, String> bimap = HashBiMap.create(map);
  assertEquals("dollar", bimap.get("canada"));
  assertEquals("canada", bimap.inverse().get("dollar"));
}