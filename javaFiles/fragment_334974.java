import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.*;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class SolutionDemo {

    private JFrame jFrame;
    private JTextPane jTextPane;
    private JScrollPane jScrollPane;

    public SolutionDemo () {
        //CREATE THE COMPONENTS AND SHOW THE FRAME WINDOW
        jFrame = new JFrame();
        jTextPane = new JTextPane();
        jScrollPane = new JScrollPane(jTextPane);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jFrame.setLayout(new FlowLayout());

        //I NEED IT TO BE HTML SO THE HYPERLINK TO BE CLICKABLE
        jTextPane.setContentType("text/html");
        jTextPane.setEditable(false);
        jTextPane.setPreferredSize(new Dimension(600, 100));
        jFrame.add(jScrollPane);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ADD LISTENER IN ORDER TO OPEN THE LINK ON BROWSER WHEN CLICKED
        jTextPane.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate (HyperlinkEvent evt) {
                if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(evt.getURL().toURI());
                        } catch (IOException | URISyntaxException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

    }

    public void init () {
        //SET GLOBAL STYLES
        jTextPane.setText(""
                + "<head>"
                + " <style type=\"text/css\">"
                + "     body{ "
                + "         color: green;"
                + "         font-family: calibri"
                + "     }"
                + " </style>"
                + "</head>");
        //ADD SOME TEXT AND HYPERLINKS
        String url = "https://www.example.com";
        appendTextPane("No tag must be inserted first in order to custom header work with this impl ");
        appendTextPane("<span>BLAH blah BLAH blah BLAH blah BLAH blah </span>");
        appendTextPane("<span style=\"color:red\">BLAH blah BLAH blah BLAH blah BLAH blah </span>");
        appendTextPane("<a href=\"" + url + "\">" + url + "</a>");
        appendTextPane("<span> BLAH blah BLAH blah BLAH blah BLAH blah <a href=\"" + url + "\">" + url + "</a></span>");
        appendTextPane("With no tag the text goes to next line <a href=\"" + url + "\">" + url + "</a>");
    }

    public void appendTextPane (String html) {
        HTMLEditorKit editor = (HTMLEditorKit) jTextPane.getEditorKit();
        HTMLDocument doc = (HTMLDocument) jTextPane.getDocument();
        String TAG;
        if (html.charAt(0) != '<') {
            TAG = "";
        } else {
            int nextSpaceIdx = html.indexOf(" ");
            int nextBrcktIdx = html.indexOf(">");
            TAG = html.substring(1, nextBrcktIdx < nextSpaceIdx ? nextBrcktIdx : nextSpaceIdx);
        }
//        System.out.println(jTextPane.getText());
        try {
            //REPLACE SPACES WITH ITS NUMERIC ENTITY REFERENCE IN ORDER TO SHOW ALL THE EXISTING SPACES 
            editor.insertHTML(doc, doc.getLength(), html.replaceAll(" ", "&#160;"), 0, 0, HTML.getTag(TAG));
        } catch (IOException | BadLocationException ex) {
        }
    }

    public static void main (String[] args) {
        new SolutionDemo().init();
    }
}