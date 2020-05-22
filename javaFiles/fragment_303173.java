List<WebElement> elements = big.findElements(By.xpath(".//*[@id='p40021404_qty']"));
if (elements.getSize() > 0) {
    big.findElement(By.xpath(".//*[@id='navbar-main']/div/div/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/button")).click();
}
else {
    System.out.println("Quantity is less !!!");
}