public class first 
{
    public static void main(String args[])
    {
        System.setProperty("webdriver.chrome.driver","C:/your_directory/chromedriver.exe");
        WebDriver dr1= new ChromeDriver(); ;
        String baseurl = "http://www.google.com/";
        dr1.get(baseurl);
    }
}