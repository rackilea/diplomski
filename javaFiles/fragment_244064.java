public void getWindows() {
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);
            System.out.println(driver.getTitle());
        }
    }