@Test(description = "Screenshot in Step")
public void screenshotInStepTest() {
    driver.get("https://www.google.com");
    step1();
    step2();
    step3();
}

@Step("Step 1")
public void step1(){
    System.out.println("step 1");
}
@Step("Step 2 with screenshot")
public void step2(){
    System.out.println("step 2");
    screenshot();
}
@Step("Step 3")
public void step3(){
    System.out.println("step 3");
}

@Attachment(value = "Screenshot", type = "image/png")
public byte[] screenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
}