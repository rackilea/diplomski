import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class TestClass2 extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    static boolean isAuthenticationStarted = false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestClass2 frame = new TestClass2();
                    frame.setVisible(true);

                    frame.addWindowStateListener(new WindowStateListener() {
                           public void windowStateChanged(WindowEvent e) {
                               // minimized
                               if ((e.getNewState() & Frame.ICONIFIED) == Frame.ICONIFIED){
                                   if (!isAuthenticationStarted)
                                   {
                                       // Authentication not started yet and window minimized
                                       frame.setState(Frame.NORMAL);
                                   }
                               }
//                             // maximized
//                             else if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH){
//
//                             }
                           }
                        });

                    frame.setAlwaysOnTop(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TestClass2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    new Thread()
                    {
                        public void run()
                        {
                            // Start authentication here
                            isAuthenticationStarted = true;

                            // if authentication is success show next jframe
                            // else restore window
                            // reset the flag only when authentication is successful 
                            // isAuthenticationStarted = false;

                            // Minimizing frame
                            setState(Frame.ICONIFIED);

                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }



                            // restoring frame
                            setState(Frame.NORMAL);

                        }
                    }.start();
                }
            }
        });// End listener


        contentPane.add(textField, BorderLayout.CENTER);
        textField.setColumns(10);
    }
}