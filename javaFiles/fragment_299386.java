import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class CookiesSample {
    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private List<Cookie> cookies = new ArrayList<>();

    @BeforeClass
    public void beforeClass() throws IOException {
        String text = "Cookies.data";
        List<String> lines = Files.readAllLines(Paths.get(text));
        lines.forEach(line -> {
            StringTokenizer token = new StringTokenizer(line, ";");
            while (token.hasMoreTokens()) {
                String name = token.nextToken();
                String value = token.nextToken();
                String domain = token.nextToken();
                String path = token.nextToken();
                Date expiry = null;

                String val = token.nextToken();
                if (!val.equals("null")) {
                    expiry = asDate(val);
                }
                Boolean isSecure = Boolean.valueOf(token.nextToken());
                Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
                cookies.add(ck);
            }
        });
    }

    @BeforeMethod
    public void beforeMethod() {
        WebDriver driver = new FirefoxDriver();
        cookies.forEach(driver.manage()::addCookie);
        drivers.set(driver);
    }

    @AfterMethod
    public void afterMethod() {
        drivers.get().quit();
        drivers.remove();
    }

    @Test(threadPoolSize = 4, invocationCount = 4)
    public void testMethod() {
        drivers.get().get("http://pagethatrequirelogin/");
    }

    private static Date asDate(String text) {
        try {
            return DateFormat.getInstance().parse(text);
        } catch (ParseException e) {
            return new Date();
        }
    }
}