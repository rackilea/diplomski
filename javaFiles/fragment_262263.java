import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestTextArea03 {

    public static void main(String[] args) {
        new TestTextArea03();
    }

    public TestTextArea03() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class TestPane extends JPanel {

        private JTextArea textArea;

        private TestPane() {
            setLayout(new BorderLayout());
            textArea = new JTextArea(10, 10);
            add(new JScrollPane(textArea));

            new TextWorker().execute();
        }

        public class TextWorker extends SwingWorker<Void, String> {

            @Override
            protected void process(List<String> chunks) {
                for (String text : chunks) {
                    textArea.append(text + "\n");
                }
            }

            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(1000);
                for (int x = 0; x < 10; x++) {
                    publish(String.valueOf(x));
                    Thread.sleep(250);
                }
                return null;
            }

        }

    }

}