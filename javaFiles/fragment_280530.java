public Gui() 
{   
    // It's arguable, but I'm paranoid, so I prefer to do anything related
    // to the UI within the EDT...
}

private void initialize() 
{
    mainWinFrm = new JFrame();
    mainWinFrm.setTitle("Inventory Tool");

    JMenuBar menuBar = new JMenuBar();
    mainWinFrm.getContentPane().add(menuBar, BorderLayout.NORTH);
    .....//allot more GUI staff getting initialize
}

public void startGui() 
{
    try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} 
    catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {}
    EventQueue.invokeLater(new Runnable() 
    {
        public void run()
        {
            try 
            {
                // Initialize here instead...
                initialize();
                window.mainWinFrm.setLocationRelativeTo(null);
                window.mainWinFrm.setMinimumSize(new Dimension(400, 200));
                window.mainWinFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.mainWinFrm.pack();
                window.mainWinFrm.setVisible(true);             
            } 
            catch (Exception e) 
                {e.printStackTrace();} 
        }
    });
}