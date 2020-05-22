import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

/**
 * A WebView which has getters and setters for content or a document url.
 *
 * Usage in FXML element is: 
 * 
 *   EITHER by specifying a url to a html document:
 * 
 *      <EmbeddedWebView fx:id="embeddedWebView" url="/embeddedwebview/embedded.html">
 *          
 *   OR by specifying CDATA escaped html content:
 *   
 *     <EmbeddedWebView fx:id="embeddedWebView">
 *         <content>
 *             <![CDATA[
 *                 <h3>Embedded WebView</h3>
 *                 <p>HTML content inline in FXML</p>
 *             ]]>
 *         </content>
 *     </EmbeddedWebView>
 *
 */
public class EmbeddedWebView extends StackPane {

    final private WebView webView;

    // For space efficiency, an alternate implementation could just 
    // rely on the content in the WebView itself rather than 
    // duplicating the content here, but it was simple to implement with a duplicate. 
    private String content;

    private String url;

    public EmbeddedWebView() {
        webView = new WebView();
        getChildren().add(webView);
    }

    public String getContent() {
        return content;
    }

    /**
     * Loads html content directly into the webview.
     * @param content a html content string to load into the webview.
     */
    public void setContent(String content) {
        this.content = content;
        webView.getEngine().loadContent(content);
    }

    public String getUrl() {
        return url;
    }

    /**
     * Loads content into the WebView from a given url.
     * The allowed url types are http, https and file.
     *
     * Additionally, content can be loaded from a classpath resource.
     * To be loaded from the classpath, the url must start with a / character
     * and specify the full resource path to the html
     * (i.e., relative resource path specifiers are not allowed).
     *
     * @param url the location of the html document to be loaded.
     */
    public void setUrl(String url) {
        if ( url == null || ! (url.startsWith("/") || url.startsWith("http:") || url.startsWith("https:") || url.startsWith("file:"))) {
            throw new IllegalArgumentException("url must start with one of http: file: https: or /");
        }

        this.url = url;

        if (url.startsWith("/")) {
            webView.getEngine().load(
                    EmbeddedWebView.class.getResource(url).toExternalForm()
            );
        } else {
            webView.getEngine().load(
                    url
            );
        }
    }
}