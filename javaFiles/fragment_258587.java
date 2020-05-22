@Test
public void noResuseIteratorTest() {

    List<String> values = new ArrayList<>();
    values.add("a");
    values.add("b");
    values.add("c");
    values.add("d");

    String first;
    String second;

    Iterator<String> iterator = values.iterator();
    if (!iterator.hasNext()) return;
    first = iterator.next();
    while (iterator.hasNext()) {
        second = iterator.next();
        System.out.println("Out: " + first + " - " + second);
        first = second;
    }
}