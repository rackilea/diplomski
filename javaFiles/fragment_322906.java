import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;



public class JTabbedPaneAssignment extends JPanel
{
    public JTabbedPaneAssignment()
    {
        final JTabbedPane tabbedPane = new JTabbedPane();
        final DayPanel dayPanel = new DayPanel();
        final JPanel officePanel = new JPanel();

        tabbedPane.add("DayGui", dayPanel);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        tabbedPane.add("OfficeAreaCalculator", officePanel);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        add(tabbedPane);
    }



    // Create JTabbedPane
    private static void createAndShowGUI()
    {
        // Create and set up the window.
        JFrame frame = new JFrame("JTabbedPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JTabbedPaneAssignment(), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}