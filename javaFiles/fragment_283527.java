List<WebElement> address = driver.findElements(By.xpath(addressXpath));
List<WebElement> addressPrimaryList = driver.findElements(By.xpath(addressPrimaryXpath));
List<WebElement> addressSecondryList = driver.findElements(By.xpath(addressSecondryXpath));
List<WebElement> addressLocationList = driver.findElements(By.xpath(addressLocationXpath));

int totalAdd = address.size();

System.out.println("Total addresses are " + totalAdd);

List<Address> addresses = new ArrayList<>();

for (int i = 0; i < totalAdd; i++) {
    Address address = new Address();
    address.setAddressPrimary(addressPrimaryList.get(i).getText());
    address.setAddressSecondry(addressSecondryList.get(i).getText());
    address.setAddressLocation(addressLocationList.get(i).getText());
    addresses.add(address);
}