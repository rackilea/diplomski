public void selectPhoneType(String option) {
       // Open the dropdown so the options are visible
        driver.findElement(By.className("dropdown-menu")).click();
        // Get all of the options
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));
        // Loop through the options and select the one that matches
        for (WebElement opt : options) {
            if (opt.getText().equals(option)) {
                opt.click();
                return;
            }
        }
        throw new NoSuchElementException("Can't find " + option + " in dropdown");
}