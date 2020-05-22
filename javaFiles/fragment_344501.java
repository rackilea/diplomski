private void waitForPortlet(String portletName, String element) {
    long startTime = System.currentTimeMillis();

    while (selenium.isElementPresent(element) == false)
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    long stopTime = System.currentTimeMillis();

    System.out.println(portletName + " load time=" + (stopTime - startTime));
}