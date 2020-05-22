import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TestMultipleLineLabel {

    private static final String TEXT = "This is\na text\non multiple lines";

    protected void initUI() {
        JFrame frame = new JFrame(TestMultipleLineLabel.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        JLabel label = new JLabel();
        label.setText(getHTMLText(TEXT));
        label.setFont(label.getFont().deriveFont(Font.PLAIN));
        panel.add(label, gbc);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(false);
        textArea.setOpaque(false);
        textArea.setWrapStyleWord(false);
        textArea.setText(TEXT);
        panel.add(textArea, gbc);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private String getHTMLText(String text) {
        return "<html>" + text.replace("\n", "<br>") + "</html>";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestMultipleLineLabel().initUI();
            }
        });
    }

}