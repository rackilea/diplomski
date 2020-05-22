public void actionPerformed(ActionEvent e)
{
    if(e.getSource() == b[7][4] && selected == false)
    {
        b[7][4].setIcon(selected);
        selected = true;
    }
    else if(e.getSource() == b[7][4] && selected == true)
    {
        b[7][4].setIcon(king);
        selected = false;           
    }
}