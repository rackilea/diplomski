import javax.swing.*;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class LimitedTextArea extends JPanel {
    private JTextArea textArea = new JTextArea(15, 50);

    public LimitedTextArea() {
        // get textArea's Document and cast to PlainDocument:
        PlainDocument document = (PlainDocument) textArea.getDocument();
        // set the document's filter with "MyFilter"
        document.setDocumentFilter(new MyFilter());

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
    }

    private static void createAndShowGui() {
        LimitedTextArea mainPanel = new LimitedTextArea();

        JFrame frame = new JFrame("LimitedTextArea");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}