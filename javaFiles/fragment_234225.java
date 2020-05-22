@Test
public void getInstance__singleCall__NotNull() {
    // no "arrange" possible
    // act
    MemberCont cut = MemberCont.getInstance();
    // assert
    assertNotNull(cut);
}

@Test
public void getInstance__multipleCalls__alwaysTheSameObject() {
    // no "arrange possible
    MemberCont cut1 = MemberCont.getInstance();
    MemberCont cut2 = MemberCont.getInstance();
    assertTrue(cut1 == cut2);
}