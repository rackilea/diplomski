@Test public void yourTest() {
  SystemUnderTest yourSystemUnderTest = Mockito.spy(new SystemUnderTest());
  doReturn(yourMockedValue).when(yourSystemUnderTest).getColumnValueRecursively(
      /* your recursive base case */);
  // ...
}