@Test(ExpectedException=NoSuchElementException.class)
  public void testSearch_NotFound() {
      List<Integer> myList = Arrays.asList(new Integer[] {1, 2, 4, 6, 3, 1, 2});  
      SimpleSearch.search(myList, 5);
  }

  @Test
  public void testSearch() {
      List<Integer> myList = Arrays.asList(new Integer[] {1, 2, 4, 6, 3, 1, 2});  
      assertEquals(1, SimpleSearch.search(myList, 22));
  }