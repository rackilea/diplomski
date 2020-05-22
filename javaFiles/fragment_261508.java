import java.awt.*;
import javax.swing.*;

public class OptionPanePanel extends JFrame
{

    private static Container layoutComponents(String title, float alignment)
    {
        JPanel container = new JPanel();
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        for (int i = 0, n = 7; i < n; i++)
        {
            JTextField jtextField = new JTextField("jtextfield " + i, n);
            jtextField.setAlignmentX(alignment);
            container.add(jtextField);
            container.add(createFiller());
        }
        JTextArea jTextArea = new JTextArea(15, 30);
        container.add(jTextArea);
        for (int i = 6, n = 13; i < n; i++)
        {
            JTextField jtextField = new JTextField("jtextfield " + i, n);
            jtextField.setAlignmentX(alignment);
            container.add(jtextField);
            container.add(createFiller());
        }
        return container;
    }

    private static Box.Filler createFiller()
    {
        return new Box.Filler(new Dimension(0, 20), new Dimension(0, 20),
                new Dimension(Short.MAX_VALUE, 20));
    }

    public static void main(String args[])
    {
        Container panel = layoutComponents("Left", Component.LEFT_ALIGNMENT);
        /*Let's check the monitor height in multi monitor setup */
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int monitorHeight = gd.getDisplayMode().getHeight();
        int result;
        if (monitorHeight <= 1024)
        {
            final Dimension preferredDimension = new Dimension(500, monitorHeight - 110);
            panel.setPreferredSize(preferredDimension);
            JScrollPane jsp = new JScrollPane(panel)
            {
                @Override
                public Dimension getPreferredSize()
                {
                    return new Dimension(500, 700);
                }
            };
            result = JOptionPane.showOptionDialog(null, jsp,
                    "",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new String[]
                    {
                        ("save"), ("cancel")
                    }, // this is the array
                    "default");
        }
        else
        {
            final Dimension preferredDimension = new Dimension(500, 700);
            panel.setPreferredSize(preferredDimension);
            result = JOptionPane.showOptionDialog(null, panel,
                    "",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new String[]
                    {
                        ("save"), ("cancel")
                    }, // this is the array
                    "default");
        }

        if (result == JOptionPane.OK_OPTION)
        {
            //do something
        }
    }
}