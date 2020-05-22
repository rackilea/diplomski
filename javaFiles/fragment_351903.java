import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIGame extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    private boolean textReceived;

     /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GUIGame frame = new GUIGame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public GUIGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            @Override
            // user pressed 'enter' key,
            public void actionPerformed(ActionEvent e) {
                textReceived = true;
                synchronized (textField) {
                    // notify game loop thread which is waiting on this event
                    textField.notifyAll();
                }
            }
        });
        contentPane.add(textField, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        textArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setForeground(Color.LIGHT_GRAY);
        textArea.setBackground(Color.BLACK);
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);

        // Start game loop in new thread since we block the thread when
        // waiting for input and we don't want to block the UI thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                playGame();
            }
        }).start();
    }

    private void playGame() {
        Random rand = new Random();
        boolean playAgain = false;
        int wins = 0, losses = 0, draw = 0;
        do {
            int num = rand.nextInt(3); // 0-2 inclusive
            textArea.append("Guess the number [0-2]: \n");
            int guess = Integer.parseInt(requestInput());
            int computerGuess = rand.nextInt(3);
            textArea.append("You: " + guess + "\tComputer: " + computerGuess + "\tNumber: " + num + "\n");
            if (guess == num && computerGuess == num || guess != num && computerGuess != num) {
                draw++;
                textArea.append("Draw!\n");
            } else if (guess == num) {
                wins++;
                textArea.append("You win!\n");
            } else if (computerGuess == num) {
                losses++;
                textArea.append("Computer wins :(\n");
            }
            textArea.append("Play again [y/n]? \n");
            playAgain = requestInput().startsWith("y");
        } while (playAgain);
        textArea.append("Wins: " + wins + "\nLosses: " + losses + "\nDraw: " + draw + "\n");
    }

    private String requestInput() {
        textField.setEnabled(true);
        textField.requestFocus();
        // wait on text field till UI thread signals a user input event
        synchronized (textField) {
            while (!textReceived) {
                try {
                    textField.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        String input = textField.getText();
        textField.setText("");
        textField.setEnabled(false);
        textReceived = false;
        return input;
    }
}