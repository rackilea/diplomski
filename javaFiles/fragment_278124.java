for (WebElement element : elements) {
        List<WebElement> mightHaveSomeDiv = element.findElements(By.cssSelector("someDiv"));

        if (mightHaveSomeDiv.size() > 0) {
            //Can iterate the list if you expect more than one div of type someDiv.
            String myText = mightHaveSomeDiv.get(0).getText();
            if (myText.contains("Ooga Booga")) {
                return element;
            }
        }
    }