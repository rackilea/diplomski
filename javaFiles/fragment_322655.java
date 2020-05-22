public void idCompare() throws Exception {
    // Wait for sometime
    Thread.sleep(2000);
    // Get expected employee id from the table
    String expectedEmployeeID = driver.findElement(By.xpath("//a[contains(text(), '"+actualEmployeeID+"')]")).getText().trim();
    // Compare actual and the expected values
    Assert.assertEquals(actualEmployeeID, expectedEmployeeID);
}