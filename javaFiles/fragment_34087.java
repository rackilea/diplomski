@Test(expected=NullPointerException.class)
public testCtorWithNullStringAndTrue() {
  Whatever.getString(null, true);
}
// same for false

// and then
public testSomeInput() {
  assertThat(Whatever.getString("whatever", true), is("expected-json-string"));
} // same for false ...