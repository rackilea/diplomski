@Test
public void testShape() {
    Diamond diamond = new Diamond();
    diamond.createShape(3);
    List<String> shape = diamond.getShape();

    assertNotNull(shape);
    assertEquals(5, shape.size());
    assertEquals("  * ", shape.get(0));
    assertEquals(" * * ", shape.get(1));
    assertEquals("* * * ", shape.get(2));
    assertEquals(" * * ", shape.get(3));
    assertEquals("  * ", shape.get(4));
}