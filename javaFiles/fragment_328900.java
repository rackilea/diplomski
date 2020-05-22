public void verifyCampaignStatusDropdownMenuOne() throws InterruptedException {

    String wipText = driver.findElement(By.linkText("TextOne")).getText() ;
    Assert.assertTrue("TextOne text is available", "TextOne".equals(wipText));
}

public void verifyCampaignStatusDropdownMenuTwo() throws InterruptedException {

    String tempText = driver.findElement(By.linkText("TextTwo")).getText() ;
    Assert.assertTrue("TextTwo text is available", "Template".equals(tempText));
}