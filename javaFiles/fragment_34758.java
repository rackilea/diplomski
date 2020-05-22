int windowCount = driver.getWindowHandles().size();
printPDF.click();
assertEquals(windowCount + 1, driver.getWindowHandles().size());
// or the Hamcrest way, if you're familiar with it
assertThat(driver.getWindowHandles(), hasSize(windowCount + 1));
// or the FEST way, if you're familiar with it
assertThat(driver.getWindowHandles()).hasSize(windowCount + 1);