//other desired capabilities
cap1.setCapability("udid", "emulator 2 udid");

AppiumDriver driver2 = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

//open URL in chrome browser
driver.get(myLink);