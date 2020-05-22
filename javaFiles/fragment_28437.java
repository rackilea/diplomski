for(int i=0; i<TRcount.size(); i++) {
    List<WebElement> TDcount = TRCount.get(i).findElements(By.tagName("td"));
    System.out.println("First TR Contains: " + TDcount.size());

    // Fetch text from individual '<td>' tags
    for(int j=0; j<TDcount.size(); j++) {
        System.out.println(TDcount.get(j).getText());
    }
}