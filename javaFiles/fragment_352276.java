import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

class FullScreenFrame extends JFrame{
    private static final int MAX_COUNT = 3;
    private static final int PERIOD = 1000;
    private JPanel panel;
    private int count;

    public FullScreenFrame(){
        super();

        setUndecorated(true);

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel = new JPanel();
        panel.setBackground(Color.GREEN);
        add(panel);

        new Timer(PERIOD, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count < MAX_COUNT) {
                    if (count % 2 == 0){
                        panel.setBackground(Color.BLACK);           
                    } else {
                        panel.setBackground(Color.GREEN);
                    }
                    count++;

                } else {
                    ((Timer) e.getSource()).stop();
                    dispose();
                }
            }

        }).start();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FullScreenFrame frame = new FullScreenFrame();
                frame.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds());
                frame.setAlwaysOnTop(true);
                frame.setVisible(true);
            }
        });
    }
}