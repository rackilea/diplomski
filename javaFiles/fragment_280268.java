driver.get("http://www.bing.com");

System.out.println("Loaded BING homepage");
System.out.println("Search for some term and then press ENTER");

BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
reader.readLine();

System.out.println("Clicking on the first link ...");

driver.findElements(By.className("sa_wr")).get(0)
      .findElement(By.tagName("a")).click();

Thread.sleep(3000);

driver.quit();