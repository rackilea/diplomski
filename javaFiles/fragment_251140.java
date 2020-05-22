// Where the grid buttons are created:
....
grid[x][y].addActionListener(createActionListener(x, y));


private ActionListener createActionListener(final int x, final int y)
{
    return new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            clickedButton(x, y);
        }
    };
}

private void clickedButton(int x, int y)
{
    System.out.println("Clicked "+x+" "+y);
}