import java.awt.Color;

import javax.swing.JTextArea;

public class Notification1
{

    static CustomFrame1 frame = new CustomFrame1(Types.NOTIFICATION);
    JTextArea display = new JTextArea();

    public Notification1(String notification)
    {
        try
        {

            frame.setLocationRelativeTo(null);
            frame.add(display);

            display.setBackground(Color.BLACK);
            display.setForeground(Color.WHITE);
            display.setWrapStyleWord(true);
            display.setLineWrap(true);
            display.setBounds(4, 20 + 4, frame.getWidth() - 8, frame.getHeight() - 50);
            display.setBorder(null);
            display.setEditable(false);
            display.setCaretColor(Color.BLACK);

            frame.slowPrint(notification, display);
            frame.setVisible(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}