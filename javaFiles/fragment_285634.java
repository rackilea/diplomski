@Test
public void login() throws InterruptedException {
    org.apache.jmeter.threads.JMeterVariables vars = org.apache.jmeter.threads.JMeterContextService.getContext().getVariables();
    driver.findElement(By.id("txtusername")).sendKeys(vars.get(userName));
    driver.findElement(By.id("txtpassword")).sendKeys(vars.get(password));
    driver.findElement(By.id("btnsubmit")).click();
    Thread.sleep(1000);
    String name = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/span[1]/span[1]")).getText();
    Assert.assertEquals(name, vars.get("Empnamecsv"));
}