// Here columns locating again on the page
System.out.println("Initial columns list size " + columns.size());
// It works same as code below
System.out.println("Initial columns list size " + driver.findElements(By.xpath("//th")).size());

// All places you use columns, columns locating elements again, and you code is same as here.
for (int i = 0; i < driver.findElements(By.xpath("//th")).size(); i++) {
    System.out.println(driver.findElements(By.xpath("//th")).get(i).getText());
    if (driver.findElements(By.xpath("//th")).get(i).getText().equals("Instructor"))
        driver.findElements(By.xpath("//th")).remove(i);
}
// output of below line = After modification column list size 3
System.out.println("After modification column list size " + driver.findElements(By.xpath("//th")).size());
return driver.findElements(By.xpath("//th"));