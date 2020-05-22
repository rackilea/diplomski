String searchText = "China";
driver.get("http://toolsqa.com/automation-practice-table/");
WebElement e = driver.findElement(By.xpath("//td[text()='" + searchText + "']"));
System.out.println(e.getText()); // you can get the text in the cell
System.out.println(e.getAttribute("outerHTML")); // you can get the HTML of the TD
e.click(); // you can click the element also but in this case it won't do anything since it's just a TD with text