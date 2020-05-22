@Test(expected = AssertionFailedError.class)
public void testMyAssertFails() {
    assertSomething("valueThatWillFail");
}

@Test
public void testMyAssertPasses() {
    assertSomething("valueThatPasses");
    //if you reach this line, no failure was thrown
}