@Test
public void parseBeanCheck() throws NumberFormatException, IOException, SAXException, IntrospectionException {

    IngenicoForwardingHelper helper = new IngenicoForwardingHelper();
    Assert.assertFalse(helper.containsSpecialCharacters("Steve Jobs"));
    Assert.assertTrue(helper.containsSpecialCharacters("Steve Jobs1"));
    Assert.assertTrue(helper.containsSpecialCharacters("Steve Jöbs"));
}