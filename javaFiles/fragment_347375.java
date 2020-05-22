import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.text.DefaultCaret;

public class TextTest extends JFrame {

    private JTextArea out = new JTextArea();
    private PipedInputStream pIn = new PipedInputStream();
    private PrintWriter pOut;

    public TextTest() {
        try {
            pOut = new PrintWriter(new PipedOutputStream(pIn));
        } catch (IOException e) {
            System.err.println("can't init stream");
        }

        DefaultCaret caret = (DefaultCaret) out.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        add(new JScrollPane(out));
        setSize(300, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Start a loop to print to the stream continuously
        new Thread() {

            public void run() {
                for (int i = 0; true; i++) {
                    pOut.println(i);
                }
            }
        }.start();

        // Start a timer to display the text in the stream every 10 ms
        new Timer(10, new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                try {
                    out.append(String.valueOf((char) pIn.read()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new TextTest();
    }
}