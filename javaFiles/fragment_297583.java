import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\NotBackedUp\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://cotacoes.economia.uol.com.br/acao/cotacoes-historicas.html?codigo=PETR4.SA&size=200&page=1&period=");
        String xPath = "//table[@id='tblInterday']/tbody//tr";
        int rows = driver.findElements(By.xpath(xPath)).size();
        for(int i=1;i<rows;i++) {
            driver.findElements(By.xpath(xPath+"["+i+"]/td")).forEach(e -> System.out.print(e.getText()+"\t"));
            System.out.println();
        }
    }
}