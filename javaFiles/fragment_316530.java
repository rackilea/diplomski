@Test
public void testJackson() throws Exception {
    List<Number> numbers = new ArrayList<Number>();
    numbers.add(100L);
    numbers.add(new Long(Integer.MAX_VALUE) + 1000L);
    numbers.add(10.0);
    ObjectMapper om = new ObjectMapper();
    System.out.println(om.writeValueAsString(numbers));
    List<Number> newNumbers = om.readValue(om.writeValueAsString(numbers), ArrayList.class);
    System.out.println(newNumbers);
    assertEquals(Integer.class, newNumbers.get(0).getClass());
    assertEquals(newNumbers.get(1).getClass(), Long.class);
    assertTrue(! numbers.equals(newNumbers) );
}