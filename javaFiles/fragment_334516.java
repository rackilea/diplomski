import java.util.UUID;

String uuid = UUID.randomUUID().toString();

//Now this uuid enter to your text box
driver.findElement(By.id("text box id")).sendKeys(uuid);