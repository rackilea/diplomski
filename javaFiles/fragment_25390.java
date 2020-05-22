public static void main(String arg[]) throws InterruptedException {
    ArrayList<String[]> data1 = new ArrayList<String[]>();
    String[] entriesArr = null;
    String[] entriesArr1 = null;  

    System.setProperty("webdriver.chrome.driver","C:\\Seleniumjava\\driver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

    //open flipkart
    driver.get("https://www.flipkart.com");

    //xpath for close the popup
    driver.findElement(By.xpath("//button[text()='✕']")).click();
    driver.findElement(By.xpath("//div[@class='O8ZS_U']/input")).sendKeys("Redmi 7 ( 32 MB , 2 GB ) Black");
    driver.findElement(By.xpath("//div[@class='O8ZS_U']/input")).sendKeys(Keys.ENTER);

    //I'm edit here
    Thread.sleep(5000);

    List<WebElement> phonenames = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
    List<WebElement> phoneprice = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
    for( int i=0;i<phonenames.size();i++){
        if(phonenames.get(i).getText().contains("Redmi 7 (Eclipse Black, 32 GB)")) {
            entriesArr = new String[]{phonenames.get(i).getText().toString(), phoneprice.get(i).getText().toString() };
            data1.add(entriesArr);
        }
    }
    driver.close();

    System.setProperty("webdriver.chrome.driver","C:\\Seleniumjava\\driver\\chromedriver.exe");
    WebDriver driver1 = new ChromeDriver();

    driver1.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    //open amazon site
    driver1.get("https:/www.amazon.in");
    driver1.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Redmi 7 ( 32 MB , 2 GB ) Black");
    driver1.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);

    Thread.sleep(3000);
    List< WebElement> phonenames2 = driver1.findElements(By.xpath("//a//span[@class='a-size-medium a-color-base a-text-normal']"));
    //I'm edit here
    List< WebElement> phoneprice1 = driver1.findElements(By.xpath("//*[@class='a-price' and @data-a-size='l']"));

    for( int j=0;j<phonenames2.size();j++) {
        if(phonenames2.get(j).getText().contains("Redmi 7 (Eclipse Black, 2GB RAM, 32GB Storage)")) {
            entriesArr1 = new String[]{phonenames2.get(j).getText().toString(), phoneprice1.get(j).getText().toString() };
            data1.add(entriesArr1);
        }
    }
    driver1.close();

    String[] d = getMinPhonePrice(data1);
    System.out.println(d[0] + ", " + d[1]);
}

//method for minimum phone price
public static String[] getMinPhonePrice(ArrayList<String[]> data){
    int value_min = Integer.parseInt(data.get(0)[1].substring(1).replace(",", ""));
    String key_min="";

    for(int i=1;i<data.size();i++) {
        int value = Integer.parseInt(data.get(i)[1].substring(1).replace(",", ""));
        if(value < value_min) {
            value_min=value;
            key_min=data.get(i)[0];
        }
    }
    String[] d = {key_min,String.valueOf(value_min)};
    return d;
}