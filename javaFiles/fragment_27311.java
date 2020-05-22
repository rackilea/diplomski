driver.get("http://www.monoprice.com/Category?c_id=122&cp_id=12212");
Thread.sleep(4000);

List<WebElement> elements =  driver.findElements(By.cssSelector("div.row>a[href$='format=2'] >span "));

System.out.println("title size is "+elements.size());

 List<WebElement> elements1 =  driver.findElements(By.cssSelector("div.text-red, div.row>a[href$='notify'] "));

System.out.println("price size is "+elements1.size());