// Inside the for loops in the createGrids method
grids[i][j] = new JButton();
// Declare x, y final
final int x = i;
final int y = j;
grids[i][j].addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){ 
        // Use x, y instead of i, j inside.
        if (squares[x][y] == 1)
        {
             System.out.println("BOmb");
        }
        else {
             grids[x][y].setVisible(false);
        }
    }
 });