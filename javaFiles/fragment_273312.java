import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextAreaExample extends JFrame
{
    private JTextArea tarea =  new JTextArea(10, 10);
    private JTextField tfield = new JTextField(10);

    private void createAndDisplayGUI()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tarea.setText("Hello there\n");
        tarea.append("Hello student://");
        JScrollPane scroll = new JScrollPane(tarea);

        tfield.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                tarea.append(tfield.getText() + "\n");
            }
        });

        tarea.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                int x = me.getX();
                int y = me.getY();
                System.out.println("X : " + x);
                System.out.println("Y : " + y);
                int startOffset = tarea.viewToModel(new Point(x, y));
                System.out.println("Start Offset : " + startOffset);
                String text = tarea.getText();
                int searchLocation = text.indexOf("student://", startOffset);
                System.out.println("Search Location : " + searchLocation);
                if (searchLocation == startOffset)
                    JOptionPane.showMessageDialog(TextAreaExample.this, "BINGO you found me.");
            }
        });

        getContentPane().add(scroll, BorderLayout.CENTER);
        getContentPane().add(tfield, BorderLayout.PAGE_END);
        pack();
        setLocationByPlatform(true);
        setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new TextAreaExample().createAndDisplayGUI();
            }
        });
    }
}