* Method to check if alert is present
     * @return True/False
     */
    public boolean isAlertPresent() {
        boolean isPresent = true;
        try {
            driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            isPresent = false;
        }
        return isPresent;
    }