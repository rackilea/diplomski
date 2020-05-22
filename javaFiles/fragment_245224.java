//To select year
driver.findElement(By.xpath("//ul[@class='uib-datepicker-pop‌​up dropdown-menu ng-scope']/li/div/table/tbody/tr/td/button/span[text() = " + syear+"]")).click();

 //To select month
driver.findElement(By.xpath("//ul[@class='uib-datepicker-pop‌​up dropdown-menu ng-scope']/li/div/table/tbody/tr/td/button/span[text() = " + smonth+"]")).click();

//To select day
driver.findElement(By.xpath("//ul[@class='uib-datepicker-pop‌​up dropdown-menu ng-scope']/li/div/table/tbody/tr/td/button/span[text() = " + sday+"]")).click();