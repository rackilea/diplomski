import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class JavaScriptProgram
{
    private WebClient webClient;
    private HtmlPage currentPage;

    public JavaScriptProgram()
    {
        webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
        webClient.setThrowExceptionOnScriptError(false);
        webClient.setJavaScriptEnabled(true);
    }

    public void visitPage(String url)
    {
        try
        {
            currentPage = (HtmlPage) webClient.getPage(url);
        }
        catch(Exception e)
        {
            // Cannot get the page
        }
    }

    public void executeJavaScript(String code)
    {
        currentPage.executeJavaScript(code);
    }

    public static void main(String[] args)
    {
        JavaScriptProgram p = new JavaScriptProgram();
        p.visitPage("http://www.stackoverflow.com");
        p.executeJavaScript("document.write('Hello World!');");
    }
}