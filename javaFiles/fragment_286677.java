public static class WatchmanTest {
   private static String watchedLog;

   @Rule
   public TestWatcher watchman= new TestWatcher() {
     @Override
     protected void failed(Throwable e, Description description) {
       watchedLog+= description + "\n";
     }

     @Override
     protected void succeeded(Description description) {
       watchedLog+= description + " " + "success!\n";
     }
   };

   @Test
   public void fails() {
     fail();
   }

   @Test
   public void succeeds() {
   }
}