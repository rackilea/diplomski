@Test
public void testParsePlaByPlayTableInvalidUrl() {
    PlayByPlayActionHtmlParser parser = new PlayByPlayActionHtmlParser("https://www.basketbal-reference.com/oxscores/pbp/201905160GS.html");
    ArrayList<Action> actions = parser.parsePlaByPlayTable();
    Assert.assertTrue(actions.isEmpty());
}