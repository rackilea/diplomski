import org.openqa.selenium.NoSuchElementException;

Scanner reader = new Scanner(System.in);  // Reading from System.in
System.out.println("Enter a year (YYYY): ");
String year = reader.nextInt();

try {
    WebElement yearButton = dr.findElement(By.xpath("//a[contains(@data-key,'" + year + "')]"));                        
    yearButton.click(); 
} catch(NoSuchElementException e) {
    System.out.println("Element does not exist!");
}