import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

public class TxtArTst implements Runnable {

    @Override // java.lang.Runnable
    public void run() {
        createAndShowGui();
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame("JSP");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea(20, 10);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 0));
        frame.add(scroll, BorderLayout.LINE_START);
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new TxtArTst());
    }
}