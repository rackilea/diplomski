//locating the amount field using xpath
    MobileElement amount = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.abc.rbanking:id/workflow_step_amount_value']"));

    amount.click();

    amount.sendKeys("1.25");
   //clicking and sendkeys would enable the disabled 'Transfer' button

   //locating the 'Date' field and click it. Clicking it would get rid of soft android keyboard
    driver.findElement(By.xpath("//*[@text = 'Date']")).click();

    Thread.sleep(3000);

    driver.findElement(By.id("com.abc.rbanking:id/back_button")).click();

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.abc.rbanking:id/PrimaryButton' and @text='Transfer']")).click();