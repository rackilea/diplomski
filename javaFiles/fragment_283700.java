Element elem = null
try {
    elem = driver.findElement(By.xpath("/html/body/form/div[4]/div[3]/div[1]/div[1]/div[1]/span[1]"));
} catch (org.openqa.selenium.NoSuchElementException e) {
    System.out.println("No Such Element Exception.");
}