package foo1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

@SuppressWarnings("serial")
public class WorkerTester extends JPanel {
    private static final int ROWS = 30;
    private static final int COLS = 60;

    // name of the Java program to run in its own process
    public static final String CLASS_TO_RUN = "StringProducer";

    // our JTextArea
    private JTextArea textArea = new JTextArea(ROWS, COLS);

    public WorkerTester() {
        // make jtextarea non-editable/focusable and put into jscrollpane
        textArea.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // this button will start the process and the worker
        JPanel btnPanel = new JPanel();
        btnPanel.add(new JButton(new WorkerAction("Start Action")));

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.PAGE_END);
    }

    // Our JButton's Action
    private class WorkerAction extends AbstractAction {
        public WorkerAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            final MyWorker myWorker = new MyWorker();
            myWorker.addPropertyChangeListener(new PropertyChangeListener() {

                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                        // you always want to check for exceptions by calling
                        // get on the worker when done
                        try {
                            myWorker.get();
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            myWorker.execute(); // run the worker
        }
    }

    private class MyWorker extends SwingWorker<Void, String> {
        private PrintStream out;
        private Scanner scanner;

        @Override
        protected Void doInBackground() throws Exception {
            @SuppressWarnings("unused")
            String separator = System.getProperty("file.separator"); // in case needed
            String classpath = "\"" + System.getProperty("java.class.path") + "\"";

            Package packageValue = WorkerTester.this.getClass().getPackage();
            String packageName = packageValue.getName() + ".";

            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe");
            processBuilder.redirectErrorStream(true); // combine error and input streams
            Process process = processBuilder.start();

            InputStream is = process.getInputStream();
            OutputStream os = process.getOutputStream();
            out = new PrintStream(os);
            scanner = new Scanner(is);

            new Thread(new ScannerGobbler(scanner)).start();

            out.println("dir"); // just to test out and see where we are
            out.println("java -cp .;" + classpath + " " + packageName + CLASS_TO_RUN);
            out.println("exit");
            out.close();
            int exitValue = process.waitFor();
            publish("Process Exited with exitValue of: " + exitValue);
            return null;
        }

        @Override
        protected void process(List<String> chunks) {
            for (String chunk : chunks) {
                textArea.append(chunk + "\n");
            }
        }

        private class ScannerGobbler implements Runnable {
            private Scanner scanner;

            public ScannerGobbler(Scanner scanner) {
                this.scanner = scanner;
            }

            @Override
            public void run() {
                while (scanner.hasNextLine()) {
                    publish(scanner.nextLine());
                }
                if (scanner != null) {
                    scanner.close();
                }
            }
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("WorkerTester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new WorkerTester());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}