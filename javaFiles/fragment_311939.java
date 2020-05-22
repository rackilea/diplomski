@Test
public void Input_CheckOnInvalidPath_ExceptionThrown() {
    Driver driver = new Driver();
    String filePath = "wrong path";
    assertNull(driver.inputProcessor(filePath));
  }