public void testBoolean(String Name, boolean clickCheckbox){
    if (clickCheckbox) {
        setPccName(Name);
        driver.findElement(By.id("testlocation")).sendKeys(getPccName());
        driver.findElement(By.id("testclick")).click());
    }
}