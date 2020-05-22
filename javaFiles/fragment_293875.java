import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

List<String> getTitles(String url)
{
    List<String> titles = new ArrayList<String>();
    WebDriver    driver = new FirefoxDriver();
    driver.get(url);
    List<WebElement> strongs = driver.findElements(By.tagName("strong"));
    for (WebElement strong : strongs)
        titles.add(strong.getText());
    driver.quit();
    return titles;
}

boolean checkTitles(List<String> titles,String suffix)
{
    for (String title : titles)
        if (title.endsWith(suffix))
            return true;
    return false;
}