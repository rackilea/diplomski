@Test
public void worldTest() {
    String[][] array = new String[1][];
    String[] element = new String[]{"Hello"};
    array[0] = element;
    assertThat(array).containsExactlyInAnyOrder(element);
}