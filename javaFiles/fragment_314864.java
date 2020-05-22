import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTextArea ta;

        public TestPane() {
            setLayout(new BorderLayout());
            ta = new JTextArea(10, 20);
            JButton btn = new JButton("Make it so");
            add(new JScrollPane(ta));
            add(btn, BorderLayout.SOUTH);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btn.setEnabled(false);
                    ta.append("Start, ");
                    SwingWorker<String, String> worker = new SwingWorker<String, String>() {

                        @Override
                        protected String doInBackground() throws Exception {
                            Thread.sleep(2000);
                            publish("Finished waiting, ");
                            return null;
                        }

                        @Override
                        protected void process(List<String> chunks) {
                            for (String text : chunks) {
                                ta.append(text);
                            }
                        }

                        @Override
                        protected void done() {
                            ta.append("Finished");
                            btn.setEnabled(true);
                        }

                    };
                    worker.execute();
                }
            });
        }

    }

}