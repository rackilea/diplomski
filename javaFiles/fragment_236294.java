import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.text.*;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

public class PreWrapApp extends javax.swing.JFrame {

    public static class PreWrapHTMLEditorKit extends HTMLEditorKit {

        ViewFactory viewFactory = new HTMLFactory() {

            @Override
            public View create(Element elem) {
                AttributeSet attrs = elem.getAttributes();
                Object elementName = attrs.getAttribute(AbstractDocument.ElementNameAttribute);
                Object o = (elementName != null) ? null : attrs.getAttribute(StyleConstants.NameAttribute);
                if (o instanceof HTML.Tag) {
                    HTML.Tag kind = (HTML.Tag) o;
                    if (kind == HTML.Tag.IMPLIED) {
                        return new javax.swing.text.html.ParagraphView(elem);
                    }
                }
                return super.create(elem);
            }
        };

        @Override
        public ViewFactory getViewFactory() {
            return this.viewFactory;
        }
    }

    public PreWrapApp() {
        JEditorPane editorPane = new JEditorPane();
        JScrollPane scrollPane = new JScrollPane();

        this.setPreferredSize(new Dimension(300, 300));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        editorPane.setEditorKit(new PreWrapHTMLEditorKit());
        editorPane.setText(""
                + "<html>"
                + "<head></head>"
                + "<body>"
                + "<pre>long text line long text line long text line long text line (two new lines here!)\n\n"
                + "long text line long text line long text line long text line long text line long text line</pre>"
                + "</body>"
                + "</html>");
        scrollPane.setViewportView(editorPane);
        getContentPane().add(scrollPane);
        pack();
    }

    public static void main(String args[]) {
        new PreWrapApp().setVisible(true);
    }
}