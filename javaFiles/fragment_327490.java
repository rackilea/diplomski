import java.awt.Color;
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class SpinnerColors
{
    public static void main(String[] args)
    {
        // Optionally:
        setLookAndFeel();

        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void setLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JSpinner spinner = new JSpinner();
        setColors(spinner, Color.BLUE, Color.RED);

        f.getContentPane().add(spinner);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static void setColors(
        JSpinner spinner, Color foreground, Color background)
    {
        JComponent editor = spinner.getEditor();
        System.out.println("Editor "+editor);
        int n = editor.getComponentCount();
        for (int i=0; i<n; i++)
        {
            Component c = editor.getComponent(i);
            System.out.println("Component "+i+": "+c);
            if (c instanceof JTextField)
            {
                c.setForeground(foreground);
                c.setBackground(background);
            }
        }
    }
}