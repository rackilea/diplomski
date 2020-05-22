@Test
public void testException() {
   try {
      amethod();
      fail("MySystemException expected");
   }
   catch (MySystemException e) {
      // Success!
   }
}