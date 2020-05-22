@Test
public void shouldCreateADefaultShannonTheorem() {
    ShannonsTheorem shannonsTheorem = new ShannonsTheorem();

    Object expectedModel = new ShannonsModel();
    assertEquals(expectedModel , shannonsTheorem.model);
    Object expectedKb = new Scanner(System.in);
    assertEquals(expectedKb  , shannonsTheorem.kb);
}