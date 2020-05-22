import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoginTerminal {

    private JTextArea log = new JTextArea(20, 40);
    private JTextField field = new JTextField();

    private int index;
    private StringBuilder textToDisplay;
    private Timer timer;

    public static void main(String[] args) {
        new LoginTerminal();
    }

    public LoginTerminal() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                textToDisplay = new StringBuilder(128);
                timer = new Timer(50, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (textToDisplay.length() > 0) {
                            String newChar = Character.toString(textToDisplay.charAt(0));
                            textToDisplay.delete(0, 1);
                            log.append(newChar);
                        } else {
                            ((Timer) e.getSource()).stop();
                        }
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.add(field, BorderLayout.NORTH);
                frame.add(new JScrollPane(log));

                log.setBackground(Color.BLACK);
                log.setForeground(Color.WHITE);
                log.setWrapStyleWord(true);
                log.setLineWrap(true);
                log.setEditable(false);
                log.setCaretColor(Color.BLACK);

                field.setBackground(Color.BLACK);
                field.setForeground(Color.WHITE);
                field.setCaretColor(Color.BLACK);
                field.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if ("  >  HELP".equalsIgnoreCase(field.getText())) {
                            dumpToLog();
                        } else {
                            dumpToLog();
                        }
                    }
                });
                field.setText("  >  ");

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public void timerPrint(String text) {

        textToDisplay.append(text).append("\n");
        if (!timer.isRunning()) {
            timer.start();
        }
    }

    public void slowPrint(String str) {
        for (int i = 0; i < str.length(); i++) {
            log.append("" + str.charAt(i));

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i == str.length() - 1) {
                log.append("\n");
            }
        }
    }

    public void dumpToLog() {
        timerPrint(field.getText());
    }

}