String value = driver.findElement(By.xpath("//div[@class='bootbox-body']")).getText();

if(value.startsWith("Incident") && value.endsWith("Updated")) {
    System.out.println("Test Pass");
}else {
    System.out.println("Test Fail");
}