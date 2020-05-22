Set<String> handles = driver.getWindowHandles();
    String currentWindowHandle = driver.getWindowHandle();
    for (String handle : handles) {
        if (!currentWindowHandle.equals(handle)) {
            driver.switchTo().window(handle);
        }
    }