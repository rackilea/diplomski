import net.java.dev.designgridlayout.DesignGridLayout;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class ConsolePanel extends JPanel {
    private JButton oneCon = new JButton(">");
    private JButton twoCon = new JButton(">");
    private JButton threeCon = new JButton(">");
    private JButton fourCon = new JButton("<");
    private JButton fiveCon = new JButton("<");
    private JButton sixCon = new JButton("<");
    private ConJTextPane console = new ConJTextPane();

    private Dimension dim = new Dimension(430,250);

    private DesignGridLayout layout = new DesignGridLayout(this);
    private AbstractDocument doc;

    public ConsolePanel () {
        buildConsole();

    }

    private void buildConsole () {
        StyledDocument styledDoc = console.getStyledDocument();
        if (styledDoc instanceof AbstractDocument) {
            doc = (AbstractDocument)styledDoc;
            doc.setDocumentFilter(new DocumentSizeFilter());
        }

        layout.row().grid().add(oneCon).add(console,3).add(fourCon);
        layout.row().grid().add(twoCon).spanRow().add(fiveCon);
        layout.row().grid().add(threeCon).spanRow().add(sixCon);

        console.setBackground(Color.BLACK);
        console.setForeground(Color.GREEN);
        console.setEditable(false);
    }

    @Override
    public Dimension getPreferredSize() {
        // comply to contract if set
        if(isPreferredSizeSet())
            return super.getPreferredSize();
        // do whatever we want
        return new Dimension(dim);
    }

    public JPanel getConsoleLayout() {
        return this;
    }

    private class ConJTextPane extends JTextPane {
        private Dimension dim = new Dimension(120,100);

        public ConJTextPane () { super(); }

        @Override
        public Dimension getPreferredSize() {
            // comply to contract if set
            if(isPreferredSizeSet())
                return super.getPreferredSize();
            // do whatever we want
            return new Dimension(dim);
        }

    }
    private class DocumentSizeFilter extends DocumentFilter {
        public DocumentSizeFilter() {

        }

        public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
            System.out.println(str);
            if (str.equals("y")) {
                System.out.println("You have pressed y.");
            }
        }

        public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a)  throws BadLocationException {

        }
    }
}