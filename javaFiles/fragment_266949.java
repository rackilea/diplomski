import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

/**
 * Created by tarun.lalwani on 5/31/17.
 */
public class TestApp {


    public static void main(String [] args) {

        BrowserMobProxyServer proxyServer = new BrowserMobProxyServer();
        proxyServer.start();
        proxyServer.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
        proxyServer.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        Proxy proxy = ClientUtil.createSeleniumProxy(proxyServer);
        FirefoxProfile profile = new FirefoxProfile();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setAcceptInsecureCerts(true);
        String host = proxy.getHttpProxy().split(":")[0];
        int port = Integer.parseInt(proxy.getHttpProxy().split(":")[1]);

        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.http", host);
        profile.setPreference("network.proxy.http_port", port);
        profile.setPreference("network.proxy.ssl", host);
        profile.setPreference("network.proxy.ssl_port", port);

        profile.setPreference("acceptInsecureCerts", true);
        cap.setCapability(FirefoxDriver.PROFILE, profile);
        FirefoxDriver driver = new FirefoxDriver(cap);

        proxyServer.newHar("mysite");

        driver.get("http://google.com");

        Har har = proxyServer.getHar();
        try {
            har.writeTo(new File("har.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}