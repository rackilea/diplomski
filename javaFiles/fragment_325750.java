List<WebElement> myList = driver.findElements(By.xpath("//li[@class='item product product-item col-lg-4 col-sm-6 col-12 nopadding']//div"));
List<String> url = new ArrayList<>();
for(WebElement myelem:myList)
{
    if(myelem.getAttribute("data-sku") != "null")
    url.add(myelem.getAttribute("data-sku"));
}
System.out.println(url);