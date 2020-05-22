/**
     * Waits for a window with a desired url to come up.<br>
     * If it does not come up in 5 seconds, it will fail.
     * <br>
     * <br>
     * This method will set the current active window to the window requested.  If you need to switch back to the previous window, use {@link #switchToWindow(String)}
     * @param regex The title of the window. Regex enabled.
     * @return
     */
    public void waitForWindow(String regex) {
        Set<String> windows = getDriver().getWindowHandles();

        for (String window : windows) {
            try {
                driver.switchTo().window(window);

                p = Pattern.compile(regex);
                m = p.matcher(driver.getCurrentUrl());

                if (m.find())
                    return switchToWindow(regex);

            } catch(NoSuchWindowException e) {
                if (attempts <= 5) {
                    attempts++;

                    Thread.sleep(1);

                    return waitForWindow(regex);
                } else {
                    fail("Window with url: " + regex + " did not appear after 5 tries. Exiting.");
                    // found
                }
            }
        }

        // when we reach this point, that means no window exists with that title..
        if (attempts == 5) {
            fail("Window with title: " + regex + " did not appear after 5 tries. Exiting.");
            return (T) this;
        } else {
            System.out.println("#waitForWindow() : Window doesn't exist yet. [" + regex + "] Trying again. " + attempts + "/5");
            attempts++;
            return waitForWindow(regex);
        }
    }