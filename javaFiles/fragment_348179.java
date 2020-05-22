driver.get("https://www.vipcars.com/search-new/?aff=vipcar&language=en&pickup_country=441&pickup_city=9747&pickup_location=14927&dropoff_country=441&dropoff_city=9747&dropoff_location=14927&pickup_date=2016-10-28&pickup_time=10:00&dropoff_date=2016-10-29&dropoff_time=10:00&rc=in_1&driver_age=29&currency=INR&show_multilingual=1&custom_css=aHR0cHM6Ly93d3cudmlwY2Fycy5jb20vY29tbW9uL2Nzcy9uZXdmb3JtLmNzcw==&step2url=aHR0cHM6Ly93d3cudmlwY2Fycy5jb20vc2VhcmNoLW5ldy8=&terms_page=aHR0cHM6Ly93d3cudmlwY2Fycy5jb20vdGVybXNfY29uZGl0aW9ucw==&googlemap=1&page=book&car_id=10067709");

new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("supplycarsIframe")));
                                driver.switchTo().frame(driver.findElement(By.id("supplycarsIframe")));

new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("proceeed_to_payment")));

WebElement procPay = driver.findElement(By.id("proceeed_to_payment"));

System.out.println(procPay.getText());

driver.switchTo().defaultContent();