@Test
public void testStoreDocument() {
    state.store("test")
    List<String> storedDocs = state.retrieveAllDocs(); //This is the only api point I can use to see the content

    assertNotNull(storedDocs);
    assertEquals("test", storedDocs.get(0));
}