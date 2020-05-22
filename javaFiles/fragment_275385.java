@Test
public void verifyExpectationWithArgumentValidatorForEachInvocation(
     final Collaborator  mock)
{
  // Inside tested code:
  new Collaborator().doSomething(true, new int[2], "test");

  new Verifications() {{
     mock.doSomething(anyBoolean, null, null);
     forEachInvocation = new Object()
     {
        void validate(Boolean b, int[] i, String s)
        {
           assertTrue(b);
           assertEquals(2, i.length);
           assertEquals("test", s);
        }
     };
  }};