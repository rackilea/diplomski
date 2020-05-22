/*
    crwood:
    http://forum.java.sun.com/thread.jspa?threadID=5137992&tstart=0
*/

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.text.*;

public class StyleTransfer {
    private JPanel getContent() {
        JTextPane left = new JTextPane();
        initialize(left);
        left.setDragEnabled(true);
        left.setTransferHandler(new StyleTransferHandler());
        JTextPane right = new JTextPane();
        right.setDragEnabled(true);
        right.setTransferHandler(new StyleTransferHandler());
        JPanel panel = new JPanel(new GridLayout(0,1));
        panel.add(new JScrollPane(left));
        panel.add(new JScrollPane(right));
        panel.add( new JScrollPane( new JTextArea() ) );
        return panel;
    }

    private void initialize(JTextPane textPane) {
        String text = "This component models paragraphs that are composed of " +
            "runs of character level attributes. Each paragraph may have a " +
            "logical style attached to it which contains the default attributes " +
            "to use if not overridden by attributes set on the paragraph or " +
            "character run. Components and images may be embedded in the flow " +
            "of text."; // 0 - 319
        StyledDocument doc = textPane.getStyledDocument();
        createStyles(doc);
        setContent(doc, text);
        styleContent(doc);
    }

    private void createStyles(StyledDocument doc) {
        Style baseStyle = doc.addStyle("base", null);
        StyleConstants.setFontFamily(baseStyle, "Lucida Sans Unicode");
        StyleConstants.setFontSize(baseStyle, 18);
        StyleConstants.setLeftIndent(baseStyle, 10f);

        Style style = doc.addStyle("bold", baseStyle);
        StyleConstants.setBold(style, true);

        style = doc.addStyle("italic", baseStyle);
        StyleConstants.setItalic(style, true);

        style = doc.addStyle("blue", baseStyle);
        StyleConstants.setForeground(style, Color.blue);

        style = doc.addStyle("underline", baseStyle);
        StyleConstants.setUnderline(style, true);

        style = doc.addStyle("green", baseStyle);
        StyleConstants.setForeground(style, Color.green.darker());
        StyleConstants.setUnderline(style, true);

        style = doc.addStyle("highlight", baseStyle);
        StyleConstants.setForeground(style, Color.yellow);
        StyleConstants.setBackground(style, Color.black);
    }

    private void setContent(StyledDocument doc, String text) {
        try {
            doc.insertString(0, text, doc.getStyle("base"));
        } catch(BadLocationException e) {
            System.out.println(e);
        }
    }

    private void styleContent(StyledDocument doc) {
        String[] names = {
            "underline", "highlight", "blue", "italic",
            "green", "green", "bold", "bold"
        };
        int[] starts  = { 22, 62, 116, 164, 233, 246, 261, 276 };
        int[] lengths = { 10, 26,  13,  18,   9,   9,  10,   6 };
        Style style = doc.getStyle("base");
        doc.setLogicalStyle(0, style);
        for(int j = 0; j < names.length; j++) {
            style = doc.getStyle(names[j]);
            doc.setCharacterAttributes(starts[j], lengths[j], style, false);
        }
    }

    public JMenuBar getMenuBar () {
        JMenuItem menuItem = null;
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Edit");
        menu.setMnemonic(KeyEvent.VK_E);
        menuItem = new JMenuItem(new DefaultEditorKit.CutAction());
        menuItem.setText("Cut");
        menuItem.setMnemonic(KeyEvent.VK_T);
        menu.add(menuItem);
        menuItem = new JMenuItem(new DefaultEditorKit.CopyAction());
        menuItem.setText("Copy");
        menuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(menuItem);
        menuItem = new JMenuItem(new DefaultEditorKit.PasteAction());
        menuItem.setText("Paste");
        menuItem.setMnemonic(KeyEvent.VK_P);
        menu.add(menuItem);
        menuBar.add(menu);
        return menuBar;
    }

    public static void main(String[] args) {
        System.setProperty("swing.aatext", "true");
        StyleTransfer test = new StyleTransfer();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setJMenuBar(test.getMenuBar());
        f.getContentPane().add(test.getContent());
        f.setSize(500,500);
        f.setLocation(100,50);
        f.setVisible(true);
    }
}

class StyleTransferHandler extends TransferHandler {
    String mimeType = DataFlavor.javaJVMLocalObjectMimeType +
                          ";class=StyledString";
    DataFlavor styledStringFlavor;

    public StyleTransferHandler() {
        try {
            styledStringFlavor = new DataFlavor(mimeType);
        } catch(ClassNotFoundException e) {
            System.out.println("Unable to create styledStringFlavor");
        }
    }

    public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {
        for(int j = 0; j < transferFlavors.length; j++) {
            if(styledStringFlavor.equals(transferFlavors[j]))
                return true;
        }
        return false;
    }

    protected Transferable createTransferable(JComponent c) {
        JTextPane textPane = (JTextPane)c;
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        StyledString ss = new StyledString("");
        if(start != -1 && start != end) {
            String text = textPane.getSelectedText();
            ss = new StyledString(text);
            StyledDocument doc = textPane.getStyledDocument();
            extractAttributes(doc, start, end, ss);
        }
        System.out.println(ss);
        return new StyledStringTransferable(ss);
    }

    private void extractAttributes(StyledDocument doc, int selectionStart,
                                   int selectionEnd, StyledString styledStr) {
        int pos = selectionStart;
        styledStr.logicalStyle = doc.getLogicalStyle(pos);
        while(pos < selectionEnd) {
            Element element = doc.getCharacterElement(pos);
            AttributeSet attrs = element.getAttributes();
            int endOffset = element.getEndOffset();
            int end = (endOffset < selectionEnd) ? endOffset : selectionEnd;
            styledStr.addAttributes(attrs, pos, end);
            pos = end;
        }
    }

    /**
     * MOVE is not supported in superclass implementation
     * and exportDone is implemented to do nothing - see api.
     */
    public void exportAsDrag(JComponent comp, InputEvent e, int action) {
        super.exportAsDrag(comp, e, action);
        Clipboard clip = comp.getToolkit().getSystemClipboard();
        exportDone(comp, clip, action);
    }

    /**
     * MOVE is not supported in superclass implementation
     * and exportDone is implemented to do nothing - see api.
     */
    public void exportToClipboard(JComponent comp, Clipboard clip, int action) {
        super.exportToClipboard(comp, clip, action);
        exportDone(comp, clip, action);
    }

    public void exportDone(JComponent comp, Clipboard clip, int action) {
        JTextPane textPane = (JTextPane)comp;
        if(action == MOVE) {
            int offset = textPane.getSelectionStart();
            int length = textPane.getSelectionEnd() - offset;
            StyledDocument doc = textPane.getStyledDocument();
            try {
                doc.remove(offset, length);
            } catch(BadLocationException e) {
                System.out.println(e);
            }
        }
    }

    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    public boolean importData(JComponent comp, Transferable t) {
        if(canImport(comp, t.getTransferDataFlavors())) {
            StyledString styledStr = null;
            try {
                styledStr = (StyledString)t.getTransferData(styledStringFlavor);
                List attrs = styledStr.attrs;
                List locs = styledStr.locs;
                JTextPane textPane = (JTextPane)comp;
                int pos = textPane.getCaretPosition();
                StyledDocument doc = textPane.getStyledDocument();
                Style logicalStyle = styledStr.logicalStyle;
                // Insert the text.
                try {
                    doc.insertString(pos, styledStr.text, logicalStyle);
                } catch(BadLocationException e) {
                    System.out.println(e);
                }
                // Appy the style runs to the inserted text.
                for(int j = 0; j < attrs.size(); j++) {
                    AttributeSet as = (AttributeSet)attrs.get(j);
                    Location loc = (Location)locs.get(j);
                    doc.setCharacterAttributes(pos, loc.length, as, false);
                    pos += loc.length;
                }
                return true;
            } catch(UnsupportedFlavorException ufe) {
                System.out.println("importData UnsupportedFlavor: " +
                                    ufe.getMessage());
            } catch(IOException ioe) {
                System.out.println("importData IO Error: " + ioe.getMessage());
            }
        }
        return false;
    }

    class StyledStringTransferable implements Transferable {
        private StyledString styledString;

        StyledStringTransferable(StyledString ss) {
            styledString = ss;
        }

        public Object getTransferData(DataFlavor flavor)
                                  throws UnsupportedFlavorException {
            if(!isDataFlavorSupported(flavor))
                throw new UnsupportedFlavorException(flavor);
            return styledString;
        }

        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[] { styledStringFlavor };
        }

        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return styledStringFlavor.equals(flavor);
        }

        public String toString() {
            return "StyledStringTransferable: " + styledString;
        }
    }
}

class StyledString {
    String text;
    List attrs;
    List locs;
    Style logicalStyle;

    public StyledString(String text) {
        this.text = text;
        attrs = new ArrayList();
        locs  = new ArrayList();
    }

    public void addAttributes(AttributeSet atts, int start, int end) {
        attrs.add(atts);
        locs.add(new Location(start, end));
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("StyledString[");
        for(int j = 0; j < attrs.size(); j++) {
            sb.append("Attributes[");
            Enumeration e = ((AttributeSet)attrs.get(j)).getAttributeNames();
            while(e.hasMoreElements()) {
                Object key = e.nextElement();
                Object value = ((AttributeSet)attrs.get(j)).getAttribute(key);
                sb.append("key:" + key + ",value:" + value + ";");
            }
            sb.append("]");
            sb.append(" for " + locs.get(j));
            if(j < attrs.size()-1)
                sb.append("\n");
        }
        System.out.println(sb);
        return sb.toString();
    }
}

class Location {
    int start;
    int length;

    public Location(int start, int end) {
        this.start = start;
        length = end - start;
    }

    public String toString() {
        return "Location[start:" + start + ",length:" + length + "]";
    }
}