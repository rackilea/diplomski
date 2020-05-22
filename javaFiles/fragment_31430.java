JPanel panel = new JPanel();
panel.setLayout(new GridLayout(rows, cols));

for (int row = 0; row < rows; ++row)
{
    for (int col = 0; col < cols; ++col)
    {
        panel.add(buttons[row][col]);
    }
}

this.add(panel);