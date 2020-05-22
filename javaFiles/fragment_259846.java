public class IERemoteWebDriver {

    public static void main(String[] args) throws IOException {

        // Assuming Remote machine IP address '192.168.10.100'
        String remote_address = "http://192.168.10.100:4444/wd/hub";
        URL remote_url = new URL(remote_address);

        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
        WebDriver wbdv = new RemoteWebDriver(remote_url, dc);
        wbdv.navigate().to("https://www.google.com/");

    }

}