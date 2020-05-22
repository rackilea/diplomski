@Test
public void shouldMapHashMapToFoo() {
    HashMap<String, String> map = new HashMap<>();
    map.put("a", "aaaa");
    map.put("b", "bbbb");

    Foo foo = modelMapper.map(map, Foo.class);

    Assert.assertEquals(foo.getA(), map.get("a"));
    Assert.assertEquals(foo.getB(), map.get("b"));

}