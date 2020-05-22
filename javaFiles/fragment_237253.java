@Test
public void startWebDriver() {
    driver.navigate().to("http://www.bbc.co.uk");

    String title = driver.getTitle();
    System.out.print(title);
    Assert.assertTrue(driver.getTitle().startsWith("bbc"), "Wrong title found: " + title);

    driver.close();
    driver.quit();
}