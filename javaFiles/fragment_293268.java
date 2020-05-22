try {
driver.switchTo().alert().accept();
}
catch (NoAlertPresentException e) {
logger.warn("Alert is not present" + e.getMessage());
}