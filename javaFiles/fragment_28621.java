int recordsCount = driver.findElements(By.xpath("//*[contains(@id,'gridBodyTable_primaryField')]")).size();
for (int i = 0; i < recordsCount; i++) {
    allRecords = driver.findElements(By.xpath("//*[contains(@id,'gridBodyTable_primaryField')]"));
    all_elements.add(allRecords.get(i).getText());
    allRecords.get(i).click();
    exitiframe();
    enteriframe("contentIFrame1");
    elementPresentFail(By.cssSelector("[id$=fieldChangeIndicatorImage]"));
    exitiframe();
    driver.findElement(By.id("Tabnav_accts-main")).click();
    enteriframe("contentIFrame0");
}