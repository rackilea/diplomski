import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import javax.imageio.ImageIO;

public class JOptionPaneExample
{
    private JDialog dialog;

    private void displayGUI()
    {
        JOptionPane optionPane = new JOptionPane(getPanel(),
                        JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.DEFAULT_OPTION, 
                        null,
                        new Object[]{}, null);
        dialog = optionPane.createDialog("import");
        dialog.setVisible(true);
    }

    private JPanel getPanel()
    {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Java Technology Dive Log");
        ImageIcon image = null;
        try
        {
            image = new ImageIcon(ImageIO.read(
                    new URL("http://i.imgur.com/6mbHZRU.png")));
        }
        catch(MalformedURLException mue)
        {
            mue.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        } 
        label.setIcon(image);

        JButton button = new JButton("EXIT");
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dialog.dispose();
            }
        });

        panel.add(label);
        panel.add(button);

        return panel;
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new JOptionPaneExample().displayGUI();
            }
        });
    }
}