/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoverflow_4589538;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

    private JLabel mActionLabel;
    private JLabel mTotalActions;
    private int mTotalActionsRan;

    private class MyAction {

        private boolean mIsRunning = false;

        public void run() {
            // Make up a random wait cycle time
            final int cycles = new Random().nextInt(100);
            for (int i = 0; i < cycles; ++i) {
                final int currentCycle = i;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                }
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                            mActionLabel.setText("Cycle " + currentCycle + " of " + cycles);
                    }
                });
            }
            completed();
        }

        public synchronized void start() {
            mIsRunning = true;
        }

        public synchronized void completed() {
            mIsRunning = false;
        }

        public synchronized boolean isRunning() {
            return mIsRunning;
    }
}
    private MyAction mAction = new MyAction();

    public Main() {
        setLayout(null);
        setBounds(40, 40, 800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                System.out.println("KeyChar: " + keyChar);
                // Press A to start an Action
                if (keyChar == 'a') {
                if (!mAction.isRunning()) {
                        mTotalActions.setText("Ran " + (++mTotalActionsRan) + " actions.");
                        System.out.println("Starting new Action");
                        Thread thread = new Thread(new Runnable() {

                            public void run() {
                                mAction.run();
                            }
                        });
                        // I had this within the run() method before
                        // but realized that it is possible for another UI event
                        // to occur and spawn another Action before, start() had
                        // occured within the thread
                        mAction.start();
                        thread.start();
                    }
                }
            }

        @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        mActionLabel = new JLabel();
        mActionLabel.setBounds(10, 10, 150, 40);

        mTotalActions = new JLabel();
        mTotalActions.setBounds(10, 50, 150, 40);

        add(mActionLabel);
        add(mTotalActions);
    }    

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}