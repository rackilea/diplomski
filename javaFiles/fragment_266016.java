import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserPreferences;
import com.teamdev.jxbrowser.chromium.BrowserType;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

/**
 * This sample demonstrates how to create Browser instance with transparent background.
 */
public class TransparentPageSample {
    public static void main(String[] args) {
        Browser browser = new Browser(BrowserType.LIGHTWEIGHT);

        // Enable support of transparent background
        BrowserPreferences preferences = browser.getPreferences();
        preferences.setTransparentBackground(true);
        browser.setPreferences(preferences);

        BrowserView view = new BrowserView(browser);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(0, 150, 255, 255));
        panel.add(view, BorderLayout.CENTER);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        browser.loadHTML("<html><body>"
                + "<div style='background: yellow; opacity: 0.7;'>\n"
                + "    This text is in the yellow half-transparent div and should "
                + "    appear as in the green due to the blue JPanel behind."
                + "</div>\n"
                + "<div style='background: red;'>\n"
                + "    This text is in the red opaque div and should appear as is."
                + "</div>\n"
                + "<div>\n"
                + "    This text is in the non-styled div and should appear as in "
                + "    the blue due to the blue JPanel behind."
                + "</div>\n"
                + "</body></html>");
    }
}