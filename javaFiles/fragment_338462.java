try {
    driver.findElement(By.className("label")).isDisplayed();
    System.out.println(" label is displayed");
    driver.findElement(By.className("label")).click();
} catch (NoSuchElementException e) {
    System.out.println("label is not displayed");
} **finally {
    System.out.println("Go to the next step");
}**

Thread.sleep(3000);

//---Second Step------------------------------------------      
try {
    driver.findElement(By.linkText("Resumé")).isDisplayed();
    System.out.println("Resumé is displayed");
    driver.findElement(By.linkText("Resumé")).click();
} catch (NoSuchElementException e) {
    System.out.println("Resumé is not displayed");
} **finally {
    System.out.println("Go to the next step");
}**