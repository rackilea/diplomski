@FindBy(how = How.ID, using = "selected-borrower")
public static WebElement borrowerName;

Select select = new Select(borrowerName);
select.selectByVisibleText(borrFullName);
String actBorrName = select.getFirstSelectedOption().getText();
System.out.println("ActBorrName: " + actBorrName);