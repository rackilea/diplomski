@Test
public void test6()
{
    test = extent.createTest("Test Case 6 : Selecting different months from secondary Calendar", "Browsing through and testing the calendar in check in/out field");

    driver.navigate().to("https://www.hoteltreeoflife.com/reservation/");
    test.info("Navigated to first page");

    driver.findElement(By.id("checkIn")).click(); // clicking on checkin field
    test.info("Clicked on Check In field");

    driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]")).click(); // If the test pass/fail result is updated.
}

@Test (dependsOnMethods = {"test6"}, alwaysRun = true)
public void test7 ()
{
    driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]")).click();//choosing date AUG 6th
    test.info("Check In Date selected");

    driver.findElement(By.id("checkOut")).click(); //clicking on checkout field

    driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]")).click(); //clicking next arrow
    test.info("Clicked on foward arrow to change check out month");

    driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[4]")).click();//choosing date AUG 16th
    test.info("Check Out Date selected");

    test.info("Finding Check Availability");
    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/button")).click();
    test.info("Clicks on Check Availability");
}