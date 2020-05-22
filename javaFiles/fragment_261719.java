List<Integer> prices = new ArrayList<>();
List<WebElement> tags = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
for (WebElement tag: tags) {
    prices.add(Integer.parseInt(tag.getText().replace(",", "")));
}
System.out.print(Collections.max(prices)); // 123900