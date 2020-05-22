import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

@SuppressWarnings("serial")
public class CallBackEgGui extends JPanel {
    private Action startThreadAction = new StartThreadAction(this);
    private JButton startThreadBtn = new JButton(startThreadAction);
    private JTextArea textArea = new JTextArea(15, 30);
    private JProgressBar progressBar = new JProgressBar();

    public CallBackEgGui() {
        progressBar.setIndeterminate(true);

        JPanel btnPanel = new JPanel();
        btnPanel.add(startThreadBtn);

        textArea.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setLayout(new BorderLayout());
        add(scrollPane);
        add(btnPanel, BorderLayout.PAGE_END);
    }

    public void showText(String text) {
        textArea.append(text + "\n");
    }

    public void startProcess() {
        // disable the JButton
        startThreadAction.setEnabled(false);

        // display a JOptionPane (or any modal JDialog) that can hold anything, including a counter if we want
        // would use a Swing Timer if I wanted to show a Timer
        String title = "Running Python Script";
        int messageType = JOptionPane.PLAIN_MESSAGE;
        JOptionPane.showMessageDialog(CallBackEgGui.this, progressBar, title , messageType);
    }

    public void endProcess(boolean result) {
        // re-enable the JButton
        startThreadAction.setEnabled(true);

        // one way to close the JOptionPane
        Window win = SwingUtilities.getWindowAncestor(progressBar);
        win.dispose();

        // display another JOptionPane that shows the result of the process
        String message = "Python script Success: " + result;
        String title = "Return From Python Script";
        int messageType = JOptionPane.PLAIN_MESSAGE;
        JOptionPane.showMessageDialog(CallBackEgGui.this, message, title , messageType);
    }

    private static void createAndShowGui() {
        CallBackEgGui mainPanel = new CallBackEgGui();

        JFrame frame = new JFrame("LongRunningTimer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

}