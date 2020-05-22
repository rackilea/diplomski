import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class KeyBindings extends JPanel {
    public KeyBindings(){
        Action upAction = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Down Arrow Pressed");
            }
        };
        Action downAction = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
               System.out.println("Down Arrow Pressed");
            }
        };
        Action leftAction = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Left Arrow Pressed");
            }
        };
        Action rightAction = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Right Arrow Pressed");
            }
        };


        getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        getActionMap().put("upAction", upAction);
        getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        getActionMap().put("downAction", downAction);
        getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        getActionMap().put("leftAction", leftAction);
        getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        getActionMap().put("rightAction", rightAction);
    }

    public Dimension getPreferredSize(){
        return new Dimension(300, 300);
    }

    public static void createAndShowGui(){
        JFrame frame = new JFrame();
        frame.add(new KeyBindings());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGui();
            }
        });
    }
}