mineGrid.setLayout(new java.awt.GridLayout(1, 0));
JButton mines[] = new JButton [gridXVal*gridYVal];
mineGrid.setLayout(new java.awt.GridLayout(gridXVal,gridYVal));
for (int i = 0 ; i < mines.length ; i++)
{
    mines [i] = new JButton(" ");
    mines [i].setActionCommand ("" + i);
    mines[i].addActionListener(listener);
    //mines [i].setBorder (null);
    //mines [i].setBorderPainted (false);
    mineGrid.add (mines [i]);
}