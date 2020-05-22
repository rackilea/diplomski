@Test
public void testRetrieveAllDocumentsWhenNotEmpty() {
    state.store("test1") 
    state.store("test2") 
    state.store("test3") 
    List<String> storedDocs = state.retrieveAllDocs();

    assertNotNull(storedDocs);
    assertEquals(3, storedDocs.size());
}