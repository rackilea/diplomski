WebDriverWait wait = new WebDriverWait(driver, 50);

try {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + "Your Report is complete" + "')]")));
    // If you get here, the condition did not timeout and so the
    // report was generated.
    log.info("Your report was generated.");
}
catch (TimeoutException ex) {
    // Timed out, the report was not generated.
    log.error("Your report was not generated.");
    throw ex;
}
finally {
    driver.close();
    // change focus back to old tab
    driver.switchTo().window(oldTab);
    Thread.sleep(3000);
}