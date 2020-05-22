Select drpdwns6 = new Select(driver.findElement(By.id("MainContent_ddlBillable")));
int drpdwns6Size = drpdwns6.getOptions().size();
for(int s6 = 0 ; s6 < drpdwns6Size ; s6++) {
    drpdwns6 = new Select(driver.findElement(By.id("MainContent_ddlBillable")));
    drpdwns6.selectByIndex(s6);
    System.out.println("selected value"+s6);

    Select drpdwns7 = new Select(driver.findElement(By.id("MainContent_ddlofflinestatus")));
    int drpdwns7Size = drpdwns7.getOptions().size();
    for(int s7 = 0 ; drpdwns7Size ; s7++) {
        drpdwns7 = new Select(driver.findElement(By.id("MainContent_ddlofflinestatus")));
        drpdwns7.selectByIndex(s7);
        System.out.println("selected value"+s7);
    }
}