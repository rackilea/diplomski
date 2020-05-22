import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
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

    public class TestPane extends JPanel implements LongTimeConsumer {

        private JTextArea ta;

        public TestPane() {
            setLayout(new BorderLayout());
            ta = new JTextArea(10, 20);
            add(new JScrollPane(ta));
            JButton btn = new JButton("Start");
            add(btn, BorderLayout.SOUTH);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btn.setEnabled(false);
                    LongTimeWorker worker = new LongTimeWorker(TestPane.this);
                    worker.addPropertyChangeListener(new PropertyChangeListener() {
                        @Override
                        public void propertyChange(PropertyChangeEvent evt) {
                            LongTimeWorker worker = (LongTimeWorker) evt.getSource();
                            if ("state".equals(evt.getPropertyName())) {
                                btn.setEnabled(worker.isDone());
                            }
                        }
                    });
                    worker.execute();
                }
            });
        }

        @Override
        public void contentUpdated(List<String> values) {
            for (String text : values) {
                ta.append(text);
                ta.append("\n");
            }
            ta.setCaretPosition(ta.getDocument().getLength());
        }

    }

    public interface LongTimeConsumer {
        public void contentUpdated(List<String> values);
    }

    public class LongTimeWorker extends SwingWorker<List<String>, List<String>> {

        private LongTimeConsumer consumer;

        public LongTimeWorker(LongTimeConsumer consumer) {
            this.consumer = consumer;
        }

        @Override
        protected List<String> doInBackground() throws Exception {
            List<String> total = new ArrayList<>(1000);
            List<String> values = new ArrayList<>(100);
            for (int index = 0; index < 1000; index++) {
                values.add("Some more text " + index);
                if (index % 100 == 0) {
                    total.addAll(values);
                    publish(values);
                    values = new ArrayList<>(100);
                }
                Thread.sleep(1);
            }
            if (!values.isEmpty()) {
                    total.addAll(values);
                    publish(values);
            }
            return total;
        }

        @Override
        protected void process(List<List<String>> chunks) {
            for (List<String> values : chunks) {
                consumer.contentUpdated(values);
            }
        }

    }
}