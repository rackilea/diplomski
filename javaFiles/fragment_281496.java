private static ArrayList<Integer> coordinates = new ArrayList<Integer>();
public static void makeCells()
{
    //Frame Specs
    JFrame frame = new JFrame();
    frame.setVisible(true);
    frame.setSize(1000,1000);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //buttons Panel
    JPanel blocks = new JPanel();
    blocks.setLayout(new GridLayout(50, 50));
    for(int col = 0; col < 50; col++)
    {
        for(int row = 0; row < 50; row++)
        {
            JButton button = new JButton();
            blocks.add(button);
            final int finalRow = row;
            final int finalCol = col;
            button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent changeColor)
                    {
                        button.setBackground(Color.YELLOW);
                        int x = finalCol, 
                            y = finalRow;
                        coordinates.add(x);
                        coordinates.add(y);
                    }});
        }
    }
    frame.add(blocks);
}