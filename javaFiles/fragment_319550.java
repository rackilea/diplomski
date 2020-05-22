for(int i = 0; i < r; i++)
{
    for(int j = 0; j < c; j++)
    {
        button[i][j] = new MySuperButton(i, j); // Store the row/column
        button[i][j].addActionListener(this);
        panel.add(button[i][j]);
    }

}