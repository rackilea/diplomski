@Test
    public void buyFootballTest() {

    WebDriver driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
    driver.get("https://www.amazon.com/");
    driver.manage().window().maximize();

    // Entry values.
    String searchForFootball = "football";
    String footballSizeVisibleText = "Junior";
    String purchaseQtyVisibleText = "2";

    // "By" locators used for process.
    By searchFieldBy = By.id("twotabsearchtextbox");
    By searchFieldFirstSuggestionBy = By.id("issDiv0");
    By firstResultTitleBy = By.xpath("//*[@id='result_0']/div/div/div/div[2]/div[2]/a/h2");
    By footballSizeDropdownBy = By.id("native_dropdown_selected_size_name");
    By purchaseQtyDropdownBy = By.id("quantity");
    By addToCartBy = By.id("add-to-cart-button");

    // This will wait a MAXIMUM of 15 seconds, but will end early if conditions are met.
    WebDriverWait noThreadSleep = new WebDriverWait(driver, 15);
    noThreadSleep.pollingEvery(250, TimeUnit.MILLISECONDS);

    // Enter the search term
    noThreadSleep.until(ExpectedConditions.visibilityOfElementLocated(searchFieldBy)).sendKeys(searchForFootball);
    noThreadSleep.until(ExpectedConditions.elementToBeClickable(searchFieldFirstSuggestionBy)).click();

    // Select the Football we want to buy
    noThreadSleep.until(ExpectedConditions.elementToBeClickable(firstResultTitleBy)).click();
    WebElement sizeDropdown = noThreadSleep.until(ExpectedConditions.visibilityOfElementLocated(
        footballSizeDropdownBy));
    Select sizeSelect = new Select(sizeDropdown);
    sizeSelect.selectByVisibleText(footballSizeVisibleText);

    // Choose to buy two.
    // driver.findElement(purchaseQtyDropdownBy).sendKeys(purchaseQty);
    WebElement qtyDropdown = noThreadSleep.until(ExpectedConditions.visibilityOfElementLocated(
        purchaseQtyDropdownBy));
    Select qtySelect = new Select(qtyDropdown);
    qtySelect.selectByVisibleText(purchaseQtyVisibleText);

    // Add to cart
    noThreadSleep.until(ExpectedConditions.elementToBeClickable(addToCartBy)).click();

    /* Continue doing things.*/
    }