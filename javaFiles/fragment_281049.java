import java.awt.event.*;
import javax.swing.*;

public class MyJTextField extends JTextField
{
    private static long lastTime = System.currentTimeMillis();

    public MyJTextField(int len)
    {
        super(len);
        addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {

                long diff = evt.getWhen() - lastTime;
                System.out.println(diff);

                if (diff > 50)
                {
                    transferFocus();
                }

                lastTime = evt.getWhen();
            }
        });
    }
}