import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SSCCE extends JPanel
{
    SSCCE()
    {
        add( new JButton("Button 1" ) );
        add( new JButton("Button 2" ) );
        add( new JButton("Button 3" ) );
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );

        // Update shared InputMap

        InputMap inputMap = (InputMap)UIManager.get("Button.focusInputMap");
        int desiredKeyCode = KeyEvent.VK_B; // type "b" to invoke Action on button

        KeyStroke spaceKeyPressed = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false);
        KeyStroke spaceKeyReleased = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true);

        // key stroke for desired key code
        KeyStroke desiredKeyPressed = KeyStroke.getKeyStroke(desiredKeyCode, 0, false);
        KeyStroke desiredKeyReleased = KeyStroke.getKeyStroke(desiredKeyCode, 0, true);

        // share the Action with desired KeyStroke
        inputMap.put(desiredKeyPressed, inputMap.get(spaceKeyPressed));
        inputMap.put(desiredKeyReleased, inputMap.get(spaceKeyReleased));

        // optionally disable original KeyStrokes
        inputMap.put(spaceKeyPressed, "none");
        inputMap.put(spaceKeyReleased, "none");
    }

    public static void main(String[] args) throws Exception
    {
        java.awt.EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
}