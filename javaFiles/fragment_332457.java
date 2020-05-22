@Test
public void getLemmaTest() {

    //... now I use List<String> instead of Object[]. declColl is already stubbed 
    // to return something, when a find(queryObj) is called.
    List<String> criteriaColl = new ArrayList<>();
    criteriaColl.add("testtest");
    DBObject queryObj = QueryBuilder.start("declensions").in(criteriaColl).get();

    String expResult = "testtest";
    String toTest = "testtest";
    String testResult = declRetriever.getLemma(toTest);

    verify(declColl).find(queryObj);
    assertEquals(expResult, testResult);  
}