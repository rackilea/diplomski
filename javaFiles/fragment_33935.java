@Test
public void simpleTest1(){
    List<AirbnbListing> list = new List<AirbnbListing>();
    // populate your list here with test elements
    // ie list.add(new AirbnbListing(...)); as many as needed

    // now if your list is 3 elements long with review ratings of [4, 5, 6],
    // we would want to test the assertion that getAvgReviews(list) is equal to 5

    assertTrue(getAvgReviews(list) == 5);
    // ... more assertions here if needed
}