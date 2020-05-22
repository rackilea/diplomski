public void actionPerformed(ActionEvent e)
{
    Labels labels;

    int result = doGame( labels);

    if( result == valueForX)
        JOptionPane.showMessageDialog(null, "X is the Winner!");
    else if( result == valueForO)
        JOptionPane.showMessageDialog(null, "O is the Winner!");
    else
        JOptionPane.showMessageDialog(null, "It's a tie!");

    for( int rowpos = 0; rowpos < 9; rowpos += 3)
    {
        for( int colpos = 0; colpos < 3; colpos ++)
            /* output (char)label[ rowpos + colpos] */;

        /* output (char)newline */;
    }
}