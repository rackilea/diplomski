import static com.ui4j.api.browser.BrowserFactory.getWebKit;

import com.ui4j.api.browser.Page;

public class Sample {

    public static void main(String[] args) {
        Page page = getWebKit().navigate("http://stackoverflow.com");
        page.show();
        page.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
}