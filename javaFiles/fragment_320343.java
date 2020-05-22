public void
 test_can_get_the_3_most_recent_changes_in_wikipedia() {

    WikipediaConnection mockConnection = mock(WikepediaConnection.class);
    when(mockConnection.makeXMLFile()).thenReturn("your test xml"); // use mockito

    XMLParser parser = new XMLParser(mockConnection) // inject the dependency in constructor

    assertThat(parser.mostRecentChanges(), allOf(
       contains("one_change_you_expect"),
       contains("the_sencond..."),
       contains("the_third")
    ); // use hamcrest for clear test expectations

 }