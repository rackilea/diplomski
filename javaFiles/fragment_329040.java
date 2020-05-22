import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

@SuppressWarnings("serial")
public class SwingWorkerExample extends JPanel {
    private JTextArea textArea = new JTextArea(30, 40);
    private MyWorker myWorker;

    public SwingWorkerExample() {
        textArea.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JButton(new AbstractAction("Start Worker") {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (myWorker != null && !myWorker.isDone()) {
                    myWorker.setLoopRunning(false);
                }

                myWorker = new MyWorker();
                myWorker.execute();
            }
        }));
        bottomPanel.add(new JButton(new AbstractAction("Stop Worker") {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (myWorker != null && !myWorker.isDone()) {
                    myWorker.setLoopRunning(false);
                }
            }
        }));

        setLayout(new BorderLayout());
        add(scrollPane);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private class MyWorker extends SwingWorker<Void, String> {
        private volatile boolean loopRunning = true;

        @Override
        protected Void doInBackground() throws Exception {
            for (int j = 0; j < 1000 && loopRunning; j++) {
                for (int i = 0; i < 1000 && loopRunning; i++) {
                    String text = String.format("My Text %03d", i);
                    publish(text);
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            }
            return null;
        }

        @Override
        protected void process(List<String> chunks) {
            for (String text : chunks) {
                textArea.append(text + "\n");
            }
        }

        @Override
        protected void done() {
            textArea.append("Done\n");

            try {
                get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        public void setLoopRunning(boolean running) {
            this.loopRunning = running;
        }

        public boolean isLoopRunning() {
            return loopRunning;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        SwingWorkerExample mainPanel = new SwingWorkerExample();
        JFrame frame = new JFrame("SwingWorkerExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}