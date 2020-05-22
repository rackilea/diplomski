driver.findElement(By.id("up-drop-zone-input")).click();
Robot r = new Robot();
r.keyPress(KeyEvent.VK_C);        // C
r.keyRelease(KeyEvent.VK_C);
r.keyPress(KeyEvent.VK_COLON);    // : (colon)
r.keyRelease(KeyEvent.VK_COLON);
r.keyPress(KeyEvent.VK_SLASH);    // / (slash)
r.keyRelease(KeyEvent.VK_SLASH);
// etc. for the whole file path

r.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
r.keyRelease(KeyEvent.VK_ENTER);