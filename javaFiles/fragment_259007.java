import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;

@SuppressWarnings("serial")
public class SSCCE2 extends JPanel {
    private static final int GAP = 4;
    private Action submitAction = new SubmitAction("Submit");
    private JTextField textField = new JTextField(40);
    private JTextArea textArea = new JTextArea(20, 40);
    private JButton submitButton = new JButton(submitAction);
    private PrintWriter printWriter = null;
    private ChatWorker chatWorker = null;

    public SSCCE2(Socket socket) throws IOException {
        printWriter = new PrintWriter(socket.getOutputStream());
        chatWorker = new ChatWorker(this, socket);
        chatWorker.execute();

        textArea.setFocusable(false);        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        textField.setAction(submitAction);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.add(textField);
        bottomPanel.add(submitButton);

        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new BorderLayout(GAP, GAP));
        add(scrollPane);
        add(bottomPanel, BorderLayout.PAGE_END);        
    }

    // Action (acts as an ActionListener) that gets text from
    // JTextField and puts it into JTextArea
    // And also sends it via PrintWriter to the Socket
    private class SubmitAction extends AbstractAction {
        public SubmitAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = textField.getText();
            textField.selectAll();

            // send this to the socket for chatting....
            if (printWriter != null) {
                printWriter.println(text);
            }

            textArea.append(text); 
            textArea.append("\n");
        }
    }

    // public method to allow outside objects to append to the JTextArea
    public void append(String text) {
        textArea.append(text);
        textArea.append("\n");
    }

}