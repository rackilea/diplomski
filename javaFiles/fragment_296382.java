import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TestTextArea {

    private void initUI() {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea chatPanel = null;
        JScrollPane scrollPanel = null;
        Container pane = frame.getContentPane();
        pane.setLayout(null);
        if (chatPanel == null) {
            chatPanel = new JTextArea("derp");
            chatPanel.setEditable(false);
            chatPanel.setForeground(new Color(10, 191, 26));
            chatPanel.setOpaque(false);
            scrollPanel = new JScrollPane(chatPanel);
            scrollPanel.setOpaque(false);
            scrollPanel.getViewport().setOpaque(false);
            scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        }

        // ## marked area ##
        scrollPanel.setBounds(9, 596, 435, 138);
        pane.add(scrollPanel);
        frame.validate();
        frame.setSize(600, 800);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTextArea().initUI();
            }
        });
    }

}