@Test
public void a_not_exists_filter_can_be_serialized() {

    String filter = filter(where("a").exists(false)).toString();
    String parsed = parse("[?(!@['a'])]").toString();

    assertThat(filter).isEqualTo(parsed);
}