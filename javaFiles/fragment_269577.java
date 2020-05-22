String path = "//div[@id='imageBlock_feature_div']//span/img";

    String url = "http://rads.stackoverflow.com/amzn/click/0615797806";
    WebDriver driver = new FirefoxDriver();
    driver.get(url);

    List<WebElement> srcs;
    srcs = driver.findElements(By.xpath(path));

    for(WebElement src : srcs) {
        System.out.println(src.getAttribute("src"));
    }

    driver.close();