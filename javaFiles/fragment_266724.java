public class MainMenu
{
    private JButton exitButton;
    private JPanel mainMenu;
    private JButton startButton;
    private JButton historyButton;

    public MainMenu()
    {
        JFrame frame = new JFrame("Main Menu");
        ///// mainMenu IS ALWAYS NULL WITHOUT THE NEXT LINE!!!!
        this.mainMenu = new JPanel();
        frame.setContentPane(this.mainMenu);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500, 500));
        frame.pack();
        frame.setVisible(true);

        exitButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e)
            {
               int exitButton = JOptionPane.YES_NO_OPTION;

               exitButton = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Warning", JOptionPane.YES_NO_OPTION);
               if (exitButton == JOptionPane.YES_OPTION)
               {
                   System.exit(0);
               }

           }
       });
    }

//Main Menu GUI setup
public static void main(String[] args)
{
    new MainMenu();
}