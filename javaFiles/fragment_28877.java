//Get link fields
List<WebElement> elements = driver.findElements(By.xpath("//a"));

// Count fields with information
int count = 0;
for ( WebElement e : elements ) {
  if ( e!=null && containsInformation(e) )
    ++count;
}

//Print out how many fields are found
System.out.println("Link text = " + count );