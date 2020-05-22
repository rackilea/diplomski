List<String> values = new ArrayList<String>();
List<WebElement> url_link = driver.findElements(By.cssSelector(".anomaly>a"));
for ( WebElement we: url_link) { 

    values.add(we.getText());
}

int ind = values.indexOf("www.test.com");

System.out.println("Index "+ind);