//...
for (int j = 0; j < sheet.getColumns() - 1; j++) {

    // add these lines
    emailTextBox = driver.findElement(By.xpath("//input[@id='email']"));
    pwdTextBox = driver.findElement(By.xpath("//input[@id='pass']"));
    loginBtn = driver.findElement(By.xpath("//button[@id='send2']"));

    // clear inputs before login. After you click loginBtn, the page 
    // changes, and references of WebElements are invalidated, 
    // thus your emailTextBox.clear(); methods threw  anexception
    emailTextBox.clear();
    pwdTextBox.clear();
    emailTextBox.sendKeys(sheet.getCell(j, i).getContents());
    pwdTextBox.sendKeys(sheet.getCell(j + 1, i).getContents());
    loginBtn.click();

}