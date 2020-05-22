import javax.swing.*;

public class OptionPaneLocation 
{   
    private void createAndDisplayGUI()
    {       
        JOptionPane optionPane = new JOptionPane("Its me"
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , null, null, "Please ENTER your NAME here");
        optionPane.setWantsInput(true);             
        JDialog dialog = optionPane.createDialog(null, "TEST");
        dialog.setLocation(10, 20);
        dialog.setVisible(true);
        System.out.println(optionPane.getInputValue());
    }

    public static void main(String... args)
    {
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                new OptionPaneLocation().createAndDisplayGUI();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
}