String selector = "div#companyIdBarCompListGrid_rows_scrollpane table tbody tr[id*=companyIdBarCompListGrid_] td span div a";
    int links = driver.findElements(By.cssSelector(selector)).size();
    System.out.println("Number of links: " + links);

    for (int i = 0; i < links; i++) {
        List<WebElement> CCTable = driver.findElements(By.cssSelector(selector));
        WebElement client = CCTable.get(i);
        System.out.println("\n"+client.getText().substring(0, 20)+"\n");
        client.click();

        // Things happen here

    }