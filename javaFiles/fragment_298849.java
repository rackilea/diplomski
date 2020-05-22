@Test
 public void shouldLogWarn(@Capturing final Logger logger) throws Exception {
   // This really ought to be a Verifications block instead
   new Expectations() {{
     logger.warn(anyString);
   }};
   MyClass my = new MyClass();
   my.foo(); 
 }