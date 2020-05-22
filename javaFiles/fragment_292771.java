// return all text in a list and build into a string
public String returnAddress(By element) {
    String[] addressSplit = driver.findElement(element).getText().split("\n");
    StringBuilder str = new StringBuilder();
    for (int addressLength = 2; addressLength <= addressSplit.length - 1; addressLength++) {
        str.append(addressSplit[addressLength] + "\n");
    }
    return str.toString().trim();
}


// this calls the method above
public String customerAddressIsPresent() {
    return returnAddress(By.id(CUSTOMER_DETAILS));
}