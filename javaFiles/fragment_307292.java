void linkToClick(str linkName) {
    WebElement link = driver.findElement(By.xpath("//table//a[contains(.,'" + linkName + "')]")); // finding link with desired name like yahoo or google
    WebElement data = driver.findElement(By.xpath("//table//a[contains(.,'" + linkName + "')]/ancestor::td/following-sibling::td/span")); // finding text in the span next to provided link
    System.out.println(data.getText()); // printing text in span
    link.click(); // clicking link
}