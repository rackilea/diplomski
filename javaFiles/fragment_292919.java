@Test(expectedExceptions = {RuntimeException.class})
public void testPrinting() {
  PrintingService service = ...
  service.print(new Document());  // How will you simulate 
                                  // throwing an exception?
}