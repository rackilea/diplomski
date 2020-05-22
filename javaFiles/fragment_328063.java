import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class YoutubeBot {
   private static final String YOUTUBE = "http://www.youtube.com";

   @SuppressWarnings("unchecked")
   public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
      WebClient webClient = new WebClient();
      webClient.setThrowExceptionOnScriptError(false);

      // This is equivalent to typing youtube.com to the adress bar of browser
      HtmlPage currentPage = webClient.getPage(YOUTUBE);

      // Get form where submit button is located
      HtmlForm searchForm = (HtmlForm) currentPage.getElementById("masthead-search");

      // Get the input field
      HtmlTextInput searchInput = (HtmlTextInput) currentPage.getElementById("masthead-search-term");

      // Insert the search term
      searchInput.setText("java");

      // Workaround: create a 'fake' button and add it to the form
      HtmlButton submitButton = (HtmlButton) currentPage.createElement("button");
      submitButton.setAttribute("type", "submit");
      searchForm.appendChild(submitButton);

      // Workaround: use the reference to the button to submit the form.
      currentPage = submitButton.click();

      // Get the div containing the filters
      HtmlElement filterDiv = currentPage.getElementById("search-lego-refinements");

      // Select the first link from the filter block (Upload date)
      HtmlAnchor sortByDateLink = ((List<HtmlAnchor>) filterDiv.getByXPath("//ul/li/a")).get(0);

      // Click the 'Upload date' link
      currentPage = sortByDateLink.click();

      System.out.println(currentPage.asText());
   }
}