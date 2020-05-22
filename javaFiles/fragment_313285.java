public void tearDown() throws Exception {
  driver.quit();

  if (verificationErrors.length() > 0) {
      fail( verificationErrors.toString() );
  }