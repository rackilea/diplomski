public static List<WebElement> lnkStockWatchlist(WebDriver driver) {
        List<WebElement> element = new ArrayList<>();
        try {
            element = driver.findElements(By.xpath("//*[@id=\"dnn_ctr769_StockWatchList_pnlContent\"]/table/tbody/tr"));
        } catch (Exception e) {
            throw (e);
        }
        return element;
    }