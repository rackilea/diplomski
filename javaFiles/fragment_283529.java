List<WebElement> address = driver.findElements(By.xpath(addressXpath));
List<WebElement> addressPrimaryList = driver.findElements(By.xpath(addressPrimaryXpath));
List<WebElement> addressSecondryList = driver.findElements(By.xpath(addressSecondryXpath));
List<WebElement> addressLocationList = driver.findElements(By.xpath(addressLocationXpath));

int totalAdd = address.size();

System.out.println("Total addresses are " + totalAdd);

List<Map<String, String> addresses = new ArrayList<>();

for (int i = 0; i < totalAdd; i++) {
    Map<String, String> address = new HashMap<>();
    address.put("addressPrimary", addressPrimaryList.get(i).getText());
    address.put("addressSecondry", addressSecondryList.get(i).getText());
    address.put("addressLocation", addressLocationList.get(i).getText());
    addresses.add(address);
}