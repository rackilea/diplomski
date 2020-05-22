public void dataVisualizationCheck1(WebDriver driver, String actualView, String reportingPeriod, String summaryReportName) throws InterruptedException {
    waitForLoad(driver, 60);
    waitForElementPresent(driver, 30, dataVisualizationHeader);
    String[] actualViews = actualView.split(",");
    boolean flag = false;
    int size = driver.findElements(By.xpath(DATAVISUALIZATIONFIELDS)).size();
    String[] xviews = new String[size]; 
    for (int i = 1; i <= size; i++) {
        xviews[i-1] = getText(driver, By.xpath("("+ DATAVISUALIZATIONFIELDS +")["+ i +"]"), " Filter criteria #" + i);
    }
    for(int i=0;i<actualViews.length;i++) {
        boolean equal = false;
        for(int j=0;j<xviews.length;j++) {
            if(actualViews[i].equals(xviews[j])) {
                equal = true;
                break;
            }
        }
        if(equal) {
            System.out.println("=> '"+actualViews[i]+"' is there in the other array...");
            break;
        } else {
            System.out.println("=> '"+actualViews[i]+"' is NOT there in the other array...");
        }
    }
}