import com.browserstack.local.Local;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

public class InterceptProxy {
    public static final String USERNAME = <BrowserStack Username>;
    public static final String AUTOMATE_KEY = <BrowserStack Key>;
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        Local browserStackLocal = new Local();
        HashMap<String, String> browserStackLocalArgs = new HashMap<String, String>();
        browserStackLocalArgs.put("key", AUTOMATE_KEY);
        browserStackLocalArgs.put("forcelocal", "true");
        browserStackLocalArgs.put("forceproxy","true");
        browserStackLocalArgs.put("force","true");
        browserStackLocalArgs.put("v", "true");
        String host=seleniumProxy.getHttpProxy().substring(0,seleniumProxy.getHttpProxy().indexOf(":"));
        String port=seleniumProxy.getHttpProxy().substring(seleniumProxy.getHttpProxy().indexOf(":")+1,seleniumProxy.getHttpProxy().length());
        browserStackLocalArgs.put("-local-proxy-host", host);
        browserStackLocalArgs.put("-local-proxy-port", port);
        browserStackLocal.start(browserStackLocalArgs);

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "62.0");
        caps.setCapability("os", "Windows");
        //caps.setCapability(CapabilityType.PROXY, seleniumProxy);
        caps.setCapability("os_version", "10");
        caps.setCapability("browserstack.local",true);

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

        // create a new HAR with the label "yahoo.com"
        proxy.newHar("yahoo.com");

        // open yahoo.com
        driver.get("http://yahoo.com");

        // get the HAR data
        Har har = proxy.getHar();

        //Writing Har to file
        har.writeTo(new File("/Users/MyUser/Desktop/HAR.txt"));
        driver.quit();
        browserStackLocal.stop();
        proxy.stop();
    }
}