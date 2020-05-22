public static void main(String[] args) throws IOException, InterruptedException 
{
    WebDriver driver;
    System.setProperty("webdriver.chrome.driver", "D:/Application/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.get("http://www.google.co.in/");

    driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
    driver.findElement(By.id("_fZl")).click();
    Boolean nextButtonFlag = true;
    // Create two separate file storing the result
    PrintStream searchTitle = new PrintStream(new File(("D:\\Titles.txt")));
    PrintStream searchLink = new PrintStream(new File(("D:\\Links.txt")));
    do
     {
               List<WebElement> findElements = driver.findElements(By.xpath("//h3[@class='r']/a"));  
               for (WebElement element : findElements)
               {
                   // Write all received links and title inn txt file
                   searchTitle.append(element.getText()+"\n");
                   searchLink.append(element.getAttribute("href")+"\n");
               }   
                    Thread.sleep(2000);
               try
               {
                   driver.findElement(By.linkText("Next")).click();
                }
               catch(Exception e)
               {
                   //  no more next button to navigate further link
                   nextButtonFlag=false;
               }

               Thread.sleep(2500);
        }
        while(nextButtonFlag);

          System.out.println("Execution done");
          searchTitle.close();
          searchLink.close();
    }
 }