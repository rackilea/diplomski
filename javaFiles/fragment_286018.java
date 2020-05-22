package awteventlistenerexample;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {
    private static final String ACTION_CLOSE = "Close";
    private JFrame frame;
    public Test() {
        frame = new JFrame();
        initActions();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.getRootPane().getActionMap().get(ACTION_CLOSE).actionPerformed(null);
            }
        });

        JPanel content = new JPanel(new FlowLayout());
        content.add(new JLabel("Creature"));
        JButton badger = new JButton("Badger");
        badger.setName("badger");
        JButton ferret = new JButton("Ferret");
        ferret.setName("ferret");
        JButton stoat = new JButton("Stoat");
        stoat.setName("stoat");
        content.add(badger);
        content.add(ferret);
        content.add(stoat);
        frame.add(content, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton close = new JButton(frame.getRootPane().getActionMap().get(ACTION_CLOSE));
        buttonPanel.add(close);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setSize(200, 150);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private void initActions() {
        Action close = new AbstractAction("Close") {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        };
        frame.getRootPane().getActionMap().put(ACTION_CLOSE, close);
    }

    public static void main(String args[]) {
        // Attach listener to AWTEvents (Mouse Events)
        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            public void eventDispatched(AWTEvent event) {
                if (event instanceof MouseEvent) {
                    MouseEvent m = (MouseEvent) event;
                    if (m.getID() == MouseEvent.MOUSE_CLICKED) {
                        System.out.println(m.toString());
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test();
            }
        });
    }
}