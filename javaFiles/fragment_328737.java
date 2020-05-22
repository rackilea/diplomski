public static void createGUI() 
{
    JFrame guiFrame = new JFrame("a");
    guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    guiFrame.setTitle("Label demo");
    JPanel mainPanel = new JPanel();
    JPanel gridPanel = new JPanel();
    JPanel buttonPanel = new JPanel(new BorderLayout());
    JButton refreshButton = new JButton("Press me to refresh labels");
    mainPanel.setLayout(new BorderLayout());
    guiFrame.getContentPane().add(mainPanel);
    gridPanel.setLayout(new GridLayout(8, 8));
    JLabel arrayLabels[] = new JLabel[64];
    for (int i = 0; i < 64; i++)
    {
        arrayLabels[i] = new JLabel("a");
    }

    for (int i = 0; i < 8*8; i++)
    {
        gridPanel.add(arrayLabels[i]);
    }
    guiFrame.getContentPane().setLayout(new BorderLayout());
    guiFrame.getContentPane().add(gridPanel,BorderLayout.CENTER);
    buttonPanel.add(refreshButton,BorderLayout.CENTER);
    guiFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    guiFrame.setVisible(true);
}