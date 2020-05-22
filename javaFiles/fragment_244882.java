import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class URLExtractor {

    private static class HTMLPaserCallBack extends HTMLEditorKit.ParserCallback {

        private Set<String> urls;

        public HTMLPaserCallBack() {
            urls = new LinkedHashSet<String>();
        }

        public Set<String> getUrls() {
            return urls;
        }

        @Override
        public void handleSimpleTag(Tag t, MutableAttributeSet a, int pos) {
            handleTag(t, a, pos);
        }

        @Override
        public void handleStartTag(Tag t, MutableAttributeSet a, int pos) {
            handleTag(t, a, pos);
        }

        private void handleTag(Tag t, MutableAttributeSet a, int pos) {
            if (t == Tag.A) {
                Object href = a.getAttribute(HTML.Attribute.HREF);
                if (href != null) {
                    String url = href.toString();
                    if (!urls.contains(url)) {
                        urls.add(url);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStream is = null;
        try {
            String u = "http://en.wikipedia.org/wiki/china";
            URL url = new URL(u);
            is = url.openStream(); // throws an IOException
            HTMLPaserCallBack cb = new HTMLPaserCallBack();
            new ParserDelegator().parse(new BufferedReader(new InputStreamReader(is)), cb, true);
            for (String aUrl : cb.getUrls()) {
                System.out.println("Found URL: " + aUrl);
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
    }
}