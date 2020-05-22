const {Builder, By, Key, until} = require('selenium-webdriver');

let driver = new Builder()
    .forBrowser('chrome')
    .build();

driver.get('http://reactdropzone.azurewebsites.net/example/');
driver.findElement(By.xpath('.//input[@type="file"]')).sendKeys('full_path_to_your_file.png');