driver.get("http://www.kayak.com/flights");
WebElement originFlight = driver.findElement(By.id("origin"));
originFlight.clear(); // clear the default airport
originFlight.sendKeys("JFK");
driver.findElement(By.id("destination")).sendKeys("LAX");
driver.findElement(By.id("travel_dates-start")).click();
WebElement startDate = driver.findElement(By.id("travel_dates-start-display"));
startDate.clear(); // clear the default start date
startDate.sendKeys("12/1/2015");
driver.findElement(By.id("travel_dates-end")).click();
WebElement endDate = driver.findElement(By.id("travel_dates-end-display"));
endDate.clear(); // clear the default end date
endDate.sendKeys("12/15/2015");