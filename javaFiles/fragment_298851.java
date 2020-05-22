@Test
 public void shouldLogWarn(@Mocked final LoggerFactory loggerFactory, @Mocked final Logger logger) throws Exception {
   MyClass my = new MyClass();
   my.foo(); 
   new Verifications() {{
     logger.warn(anyString);
   }};
 }