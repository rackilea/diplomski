// These tests all pass.
public static class HasExpectedException {
     @Rule
     public ExpectedException thrown= ExpectedException.none();

     @Test
     public void throwsNothing() {
         // no exception expected, none thrown: passes.
     }

     @Test
     public void throwsNullPointerException() {
         thrown.expect(NullPointerException.class);
         throw new NullPointerException();
     }

     @Test
     public void throwsNullPointerExceptionWithMessage() {
         thrown.expect(NullPointerException.class);
         thrown.expectMessage("happened?");
         thrown.expectMessage(startsWith("What"));
         throw new NullPointerException("What happened?");
     }
}