WebElement confirmation = remoteDriver.findElementByName("Confirmation");

if ( confirmation.isDisplayed() && confirmation.isEnabled()) {
   ...
}
else {
   ...
}