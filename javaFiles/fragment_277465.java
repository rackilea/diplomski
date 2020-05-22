@Test
public void testListOfClasses() {

    List<Class<?>> classList = new ArrayList<Class<?>>();

    classList.add(Integer.class);
    classList.add(String.class);
    classList.add(Double.class);

    assertTrue("List contains Integer class", classList.contains(Integer.class));
}