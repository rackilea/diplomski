import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TestTextArea {
    private JTextArea textArea;

    public TestTextArea() {
    }

    private void initUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JTEXTBOX
        textArea = new JTextArea(10, 25);
        textArea.setEditable(false);
        textArea.setText("Here is my textarea\nI can finally see it.\nYeah!!! :-)");

        // JSCROLLPANE
        JScrollPane scroll1 = new JScrollPane(textArea);
        scroll1.setPreferredSize(new Dimension(200, 250));
        scroll1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scroll1);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    TestTextArea test = new TestTextArea();
                    test.initUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}