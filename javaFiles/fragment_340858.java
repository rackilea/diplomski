public class shop
{
    public static void main(String[] args)
    {
    WebDriver driver= new ChromeDriver();
    driver.get("www.myshopping.com");
    List<WebElement> atags =  driver.findElements(By.tagName("a"));
    for(WebElement atag:atags)
         System.out.println("Text is : " + atag.getAttribute("innerHTML"));
    }
}