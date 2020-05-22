@Test
public void testNotEmptyOffer() {
    // Given
    testOfferServiceImpl = new OfferServiceImpl();
    testOfferServiceImpl.hardDiscAddress = "C:/";
    testOfferServiceImpl.offerDAO = offerDAOMock;

    // Spy (partially mock) the object
    testOfferServiceImpl = Mockito.spy(testOfferServiceImpl);
    doReturn(Arrays.asList("one", "two", "three")).
       when(testOfferServiceImpl).getOfferPictures(offerMock)

    // Test your logic here
}