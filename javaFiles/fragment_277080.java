@Test
public void testSortList() {

    List<Element> list = new ArrayList<>();
    list.add(new Element("A", 1));
    list.add(new Element("A", 2));
    list.add(new Element("B", 1));
    list.add(new Element("A", 3));
    list.add(new Element("B", 2));

    list.sort((element1, element2) -> element1.getValue().compareTo(element2.getValue()));

    assertThat(list.get(0).getValue()).isEqualTo("A");
    assertThat(list.get(0).getPosition()).isEqualTo(1);
    assertThat(list.get(1).getValue()).isEqualTo("A");
    assertThat(list.get(1).getPosition()).isEqualTo(2);
    assertThat(list.get(2).getValue()).isEqualTo("A");
    assertThat(list.get(2).getPosition()).isEqualTo(3);
    assertThat(list.get(3).getValue()).isEqualTo("B");
    assertThat(list.get(3).getPosition()).isEqualTo(1);
    assertThat(list.get(4).getValue()).isEqualTo("B");
    assertThat(list.get(4).getPosition()).isEqualTo(2);
}