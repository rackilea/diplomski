public static void clickOnEachLinkOnAPage(String tagName, String homePageTitle) {

    int numberOfElementsFound = getNumberOfElementsFound(By.tagName(tagName));
    // System.out.println(numberOfElementsFound);
    String currentWindow = driver.getWindowHandle();
    for (int pos = 0; pos < numberOfElementsFound; pos++) {
        String linkText = getElementWithIndex(By.tagName(tagName), pos).getText().trim();
        if (linkText.length() != 0) {
            String url = getElementWithIndex(By.tagName(tagName), pos).getAttribute("href");
            getElementWithIndex(By.tagName(tagName), pos).click();
            String newWindow = driver.getWindowHandle();
            Generic.handleMultipleWindows(newWindow);
            String pageTitle = driver.getTitle();
            linkText = StringUtils.abbreviate(linkText, 10);
            //   System.out.println(pos +","+linkText+","+url+","+pageTitle);
            System.out.println(linkText + "," + url + "," + pageTitle);
            closeAllOtherWindows(newWindow);
            Generic.handleMultipleWindows(currentWindow);
            String pageTitleCurrent = driver.getTitle();
            if (!pageTitleCurrent.equals(homePageTitle)) {
                driver.navigate().back();
            }
        }
    }
}