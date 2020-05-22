import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyForm implements Runnable, ProgressListener {
    // instance variables
    private JFrame frame;
    private MyLoginPanel loginPanel;
    private MyWelcomePanel welcomePanel;
    private MyFormPanel formPanel;

    /** Empty constructor of objects of class SomeClassUI. */
    public SomeClassUI() {
        // ...
    }

    /** Interface initialization. */
    @Override
    public void run() {
        // These should handle their own component initialization.
        // They should, at least, receive a reference to the listener.

        loginPanel = new MyLoginPanel(this);
        welcomePanel = new MyWelcomePanel(this);
        formPanel = new MyFormPanel(this);

        frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(loginPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /** */
    @Override
    public void progressFrom(AppState whoTriggeredIt) {
        switch (whoTriggeredIt) {
            case LOGIN:
            frame.setContentPane(welcomePanel);
            frame.pack();
            return;

            case WELCOME:
            frame.setContentPane(formPanel);
            frame.pack();
            return;

            default: return;
        }
    }


    /** */
    public void go() {
        SwingUtilities.invokeLater(this);
    }


    /** */
    public static void main(String[] args) {
        new SomeClassUI().go();
    }
}