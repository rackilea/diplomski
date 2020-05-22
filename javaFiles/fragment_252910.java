public class americangolf {

public static void main(String[] args) 
{
    WebDriver driver = new FirefoxDriver();
        driver.get("http://www.americangolf.co.uk/golf-clubs/fairway-woods");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> elem = driver.findElements(By.xpath("//div[@class='refinement brand']/descendant::a"));
        for(WebElement li:elem)
        {
            System.out.println(li.getText());
        }

        List<WebElement> elem1 = driver.findElements(By.xpath("//div[@class='refinement brand']/descendant::a/span[2]"));
        int sum = 0;
        for(WebElement li1:elem1)
        {
            System.out.println(li1.getText());
            String s = li1.getText().replace("(", "");
            sum = sum + Integer.parseInt(s.replace(")", ""));
        }


        System.out.println("Total sum is: " + sum);

        int totalAppearingOnPage = Integer.parseInt(driver.findElement(
                By.xpath("//h1[normalize-space(text())='Best Selling Fairway woods']/following::div[@class='results-hits'][1]/span")).
                getText());
        System.out.println("Total appearing on page: " + totalAppearingOnPage);
        driver.quit();
    }
    }