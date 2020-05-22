public void selectSortby(String sortBy) {
  // click on dropdown to expand options
  driver.findElement(By.xpath("//div[span[text()='Sort by:']]//g-dropdown-button").click();
  // choose option
  driver.findElement(By.xpath("//g-menu-item/div[text()='"+sortBy+"']")).click();
}