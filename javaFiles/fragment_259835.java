/**
     * Switches the current window based on title.
     * @param regex A regular expression window title.
     * @return
     */
    public void switchToWindow(String regex) {
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            getDriver().switchTo().window(window);
            System.out.println("#switchToWindow() : url=" + driver.getCurrentUrl());

            p = Pattern.compile(regex);
            m = p.matcher(driver.getCurrentUrl());

            if (m.find())
                // found
        }

        fail("Couldn't switch to window with urlregex: " + regex + "!");
    }