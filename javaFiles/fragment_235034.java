driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

List<Double> pricesDouble = new ArrayList<>();
//Get all prices without currency of FROM Flight section
List<WebElement> fromPrices = driver.findElements(By.cssSelector("#divAvailabilityOut span[data-bind='html: PriceWithoutCurrencySymbol']"));
//To get all prices without currency of TO Flight section use code below
//List<WebElement> toPrices = driver.findElements(By.cssSelector("#availabilityLoadingIn span[data-bind='html: PriceWithoutCurrencySymbol']"));

fromPrices.forEach(e -> {
    try {
        pricesDouble.add(Double.parseDouble(e.getAttribute("innerText")));
    } catch (NumberFormatException ex) {
        System.err.println("Ilegal input");
    }
});
//Assert.assertTrue(pricesDouble.size()>0, "Get at least one price");

int indexOfMaxPrice = pricesDouble.indexOf(Collections.max(pricesDouble););

//Get clickable element with max price
fromPrices.get(indexOfMaxPrice).findElement(By.xpath("ancestor::div[@class='totalPrice']")).click();