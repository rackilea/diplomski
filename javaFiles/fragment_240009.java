public class HTMLLabelTest extends JFrame {

public static void main(String[] args) throws Exception {
    SwingUtilities.invokeAndWait(new Runnable() {
        @Override
        public void run() {
            JFrame frame = new HTMLLabelTest();
            frame.pack();
            frame.setVisible(true);
        }
    });
}

public HTMLLabelTest() {

    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });

    HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
    StyleSheet styleSheet = new StyleSheet();
    URL resource = getClass().getResource("/stylesheet.css");
    styleSheet.importStyleSheet(resource);
    htmlEditorKit.setStyleSheet(styleSheet);

    JLabel label = new JLabel();
    label.setText("<html><B>Some HTML Formatted</B> text</html>");
    label.setOpaque(false);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setHorizontalTextPosition(JLabel.CENTER);
    label.setPreferredSize(new Dimension(30,20));

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(label);

    panel.setOpaque(true);
    panel.setBackground(Color.WHITE);

    add(panel);
    setPreferredSize(new Dimension(300,200));
}