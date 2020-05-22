@Test
 public void shouldLogWarn(@Capturing final Logger logger) throws Exception {
   MyClass my = new MyClass();
   my.foo(); 
   new Verifications() {{
     logger.warn(anyString);
   }};
 }