@Test
public void testStuff() throws Exception {
    Map<String, String> map = new HashMap<>();
    Object data = new Object();
    Response target = new Response<>(map, data);
    assertThat(target.map, sameInstance(map));
    assertThat(target.data, sameInstance(data));
}