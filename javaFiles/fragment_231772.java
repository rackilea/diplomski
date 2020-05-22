WebElement select = webDriver.findElement(selector);
        List<WebElement> optionList = select.findElements(By.tagName("option"));
        for (WebElement option : optionList) {
            if (option.getText().trim().equalsIgnoreCase("your value")) {
                option.click();
                break;
            }
        }