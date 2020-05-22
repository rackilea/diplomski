import java.awt.Color;
import javax.swing.*;

public class Validation extends JFrame
{
    private static Validation valid = new Validation();
    static
    {
        String choice = JOptionPane.showInputDialog(valid, "Enter Password", "Password", JOptionPane.PLAIN_MESSAGE);
        if ((choice == null) || ((choice != null) && !(choice.equals("password"))))
            System.exit(0);
    }

    private static void createAndDisplayGUI()
    {
        valid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        valid.setLocationRelativeTo(null);

        valid.getContentPane().setBackground(Color.YELLOW);

        valid.setSize(200, 200);
        valid.setVisible(true);
    }
    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndDisplayGUI();
            }
        });
    }
}