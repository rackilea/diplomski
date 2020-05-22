public static void main(String[] args) 
{
    EventQueue.invokeLater(new Runnable() 
    {
        public void run()
        {
            // Initialise the system look and feel...
            try 
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
            {
            }
            Gui window = new Gui();
            window.mainWinFrm.setLocationRelativeTo(null);
            window.mainWinFrm.setMinimumSize(new Dimension(400, 200));
            window.mainWinFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.mainWinFrm.pack();
            window.mainWinFrm.setVisible(true);             
        }
    });
}

public Gui() 
{   
    initialize();
}

private void initialize() 
{
    mainWinFrm = new JFrame();
    mainWinFrm.setTitle("Inventory Tool");

    JMenuBar menuBar = new JMenuBar();
    mainWinFrm.getContentPane().add(menuBar, BorderLayout.NORTH);
    .....//allot more GUI staff getting initialize
}