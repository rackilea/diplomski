driver.get("http://the-internet.herokuapp.com/windows");
    String firstWindow = driver.getWindowHandle();
    System.out.print("First windowhandle: " + firstWindow + "\n");

    System.out.print("Clicking on 'Click Here' \n");
    driver.findElement(By.linkText("Click Here")).click();

    Set<String> stringSet = driver.getWindowHandles();
    System.out.print("All windowhandles: " + stringSet + "\n");
    List<String> handles = new ArrayList<>(stringSet);

    System.out.print("Switching to new window \n");
    driver.switchTo().window(handles.get(1));
    //wait for Title to change to second tab title
    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("New Window"));

    System.out.print("Second (and current) windowhandle: " + driver.getWindowHandle() + "\n");

    System.out.print("Switching back to first Window. \n");
    driver.switchTo().window(firstWindow);

    //wait for Title to change back to first title
    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("The Internet"));

    System.out.print("Last used windowhandle: " + driver.getWindowHandle() + "\n");