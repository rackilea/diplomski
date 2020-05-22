private void displayGrid()
{
   Case arrayGrid [][] = Grid.returnArray();

   for(int i = 0; i < Settings.returnYGrid(); i++)
    {
        for(int j = 0; j < Settings.returnXGrid(); j++)
        {
             Case caase = arrayGrid [i][j];
             panel.add(caase.getButton());
        }
    }
    panel.revalidate();
    panel.repaint();
}