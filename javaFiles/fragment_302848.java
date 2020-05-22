public class HighlightHyperlinkExample {
    private static Element lastHyperlinkElementEntered;
    private static JEditorPane textPane;


    public static void main(String[] args) {
        textPane = new JEditorPane();
        textPane.setContentType(new HTMLEditorKit().getContentType());
        JScrollPane scrollPane = new JScrollPane(textPane);
        textPane.setText(
                "Sample text with <a href=\"x\">a link</a> and another <a href=\"x\">link</a>.");

        initListeners();

        JFrame frame = new JFrame();
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private static void initListeners() {
        textPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                removeHyperlinkHighlight();
            }
        });
        textPane.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
                Point pt = new Point(e.getX(), e.getY());
                int pos = textPane.viewToModel(pt);
                if (pos >= 0) {
                    HTMLDocument hdoc = (HTMLDocument) textPane.getDocument();
                    Element elem = hdoc.getCharacterElement(pos);
                    if (elem != null) {
                        AttributeSet a = elem.getAttributes();
                        AttributeSet anchor = (AttributeSet) a.getAttribute(HTML.Tag.A);
                        if (anchor != null) {
                            //only highlight anchor tags
                            highlightHyperlink(elem);
                        } else {
                            removeHyperlinkHighlight();
                        }
                    }
                }
            }
        });
    }

    private static void removeHyperlinkHighlight() {
        changeColor(lastHyperlinkElementEntered, Color.BLUE);
        lastHyperlinkElementEntered = null;
    }

    private static void highlightHyperlink(Element hyperlinkElement) {
        if (hyperlinkElement != lastHyperlinkElementEntered) {
            lastHyperlinkElementEntered = hyperlinkElement;
            changeColor(hyperlinkElement, Color.RED);
        }
    }

    private static void changeColor(Element el, Color color) {
        if (lastHyperlinkElementEntered != null) {
            HTMLDocument doc = (HTMLDocument) textPane.getDocument();
            int start = el.getStartOffset();
            int end = el.getEndOffset();
            StyleContext ss = doc.getStyleSheet();
            Style style = ss.addStyle("HighlightedHyperlink", null);
            style.addAttribute(StyleConstants.Foreground, color);
            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }
}