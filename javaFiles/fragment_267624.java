WebElement toggle = driver.findElement(By.xpath("//*[@name='formly_35']/child::div[1]//*[contains(@class,'toggle-switch-animate')]"));

boolean onOff = toggle.getAttribute("class").contains("switch-on");

if (onOff) {
  log.debug("IS ON");
} else {
  log.debug("IS OFF");
}


toggle.click();


if (onOff) {
  log.debug("IS ON");
} else {
  log.debug("IS OFF");
}