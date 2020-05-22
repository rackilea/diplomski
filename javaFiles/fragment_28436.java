List<WebElement> TRcount = driver.findElements(By.tagName("tr"));

for(WebElement e : TRcount) {
    List<WebElement> TDcount = e.findElements(By.tagName("td"));
    System.out.println("First TR Contains: " + TDcount.size());
}