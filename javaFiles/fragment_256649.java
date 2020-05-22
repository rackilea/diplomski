public void testBoolean(String Name, boolean clickCheckbox){
    setPccName(Name);
    driver.findElement(By.id("testlocation")).sendKeys(getPccName());
    driver.findElement(By.id("testclick")).click());

    if (clickCheckbox) {
        clickCheckbox();
    }
}