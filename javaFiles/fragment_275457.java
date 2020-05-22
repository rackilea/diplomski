import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;

public class KaraokeTest {

    private int[] timings = {2000, 4000, 0, 3000, 2000};//word timings
    private String[] words = {"Hel", "lo", " ", "wor", "ld"};//each indiviaul word
    private String sentence = "Hello world";//entire string for writing to JSCrollPane
    private DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
    private int count = 0;
    private boolean fisrTime = true;
    private JFrame frame;
    private JTextPane jtp;
    private JButton startButton;
    private AtomicBoolean done = new AtomicBoolean(false);

    public KaraokeTest() {
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        jtp = new JTextPane();

        jtp.setText(sentence);
        jtp.setEditable(false);

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                startKaraoke();
            }
        });

        frame.add(jtp, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private void startKaraoke() {
        if (fisrTime) {
            startButton.setEnabled(false);
            fisrTime = false;
        }

        createAndStartTimer(timings[count], count);

        Timer t = new Timer(1, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (done.get()) {
                    count++;
                    if (count == timings.length) {
                        JOptionPane.showMessageDialog(frame, "Done");
                        startButton.setEnabled(true);
                        count = 0;
                        fisrTime = true;
                        done.getAndSet(false);
                        ((Timer) ae.getSource()).stop();
                    } else {
                        ((Timer) ae.getSource()).stop();
                        startKaraoke();
                    }
                }
            }
        });
        done.getAndSet(false);//to synchronize when the remove highlight timer is done so a clash between adding highlights before the timer is done doesnt occur
        t.start();
    }

    private void createAndStartTimer(int delay, final int count) {
        int sp = 0;
        for (int i = 0; i < count; i++) {
            sp += words[i].length();
        }
        try {
            jtp.getHighlighter().addHighlight(sp, sp + words[count].length(), highlightPainter);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }

        Timer t = new Timer(delay, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jtp.getHighlighter().removeAllHighlights();
                done.getAndSet(true);//so that out other timer knows we are done completly and can add new higlights
            }
        });
        t.setRepeats(false);
        t.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KaraokeTest();
            }
        });
    }
}