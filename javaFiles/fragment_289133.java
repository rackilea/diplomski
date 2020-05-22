class GridPane extends JPanel
{
   public GridPane(int row,int col)
    {
         setLayout(new GridLayout(row,col));
         setBorder(BorderFactory.createEmptyBorder(1,1,1,1));

         for (int i =1; i<=(row*col); i++)
          {
             JPanel pan = new JPanel();
             pan.setPreferredSize(new Dimension(30,30));
             pan.setBorder(BorderFactory.createLineBorder(Color.GRAY));
             add(pan);
           } 

    } 
}