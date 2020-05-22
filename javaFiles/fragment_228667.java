@Test
public void test() {
  // GIVEN some preconditions

  // WHEN
  Throwable thrown = catchThrowableOfType(() -> { throw new IllegalStateException("boom!"); }, 
                                         IllegalStateException.class);
  // THEN
  assertThat(thrown.getMessage()).matches(".oo.")
                                 .containsPattern("oo.");
  // or even better thanks to Rolland Illig suggestion
  assertThat(thrown).hasMessageMatching(".oo.");

}