import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Phystem
 */
public class Yatra {

    WebDriver driver;

    public Yatra() {
        System.setProperty("webdriver.chrome.driver", "D:\\Test\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void start() {
        driver.get("https://www.yatra.com/");
        String DepartDte = "29-March-2017";
        String splitter[] = DepartDte.split("-");
        String Departdate = splitter[0];
        System.out.println("date" + " " + Departdate);
        String Departmonth = splitter[1];
        System.out.println("month" + " " + Departmonth);
        String Departyear = splitter[2];
        System.out.println("year" + " " + Departyear);
        String returDte = "";
        driver.findElement(By.name("flight_depart_date")).click();
        selectDate(Departdate, Departmonth, Departyear);
    }

    private void selectDate(String Departdate, String Departmonth, String Departyear) {
        //div[@id='PegasusCal-0']//a[@id='a_2017_3_13']
        String dateXpath = String.format(
                "//div[@id='PegasusCal-0']//a[@id='a_%s_%d_%s']",
                Departyear, getMonthNum(Departmonth), Departdate);
        driver.findElement(By.xpath(dateXpath)).click();
    }

    private int getMonthNum(String monthName) {
        try {
            Date date = new SimpleDateFormat("MMM").parse(monthName);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal.get(Calendar.MONTH) + 1;
        } catch (ParseException ex) {
            Logger.getLogger(Yatra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    public static void main(String[] args) {
        new Yatra().start();
    }

}