@Test
public void testException() {
   try {
      amethod();
      fail("MySystemException expected");
   }
   catch (MySystemException e) {
      String expectedMessage1 = "An error occured due to case 1 being incorrect.";
      String expectedMessage2 = "An error occured as case 2 could not be found";
      assertThat(e.getMessage(), 
                 anyOf(equalTo(expectedMessage1), equalTo(expectedMessage2)));
   }
}