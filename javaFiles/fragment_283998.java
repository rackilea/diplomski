Stack<Tile> history = new Stack<Tile>();

public void actionPerformed(ActionEvent e)
{
    String choice = e.getActionCommand();

    if(choice.equals("Click"))
    {
        for(int j=0; j<6; j++)
        {
            for(int k=0; k<6; k++)
            {
                if(tile[j][k]==e.getSource())
                { 
                    current+=(tile[j][k].getTile().letter());  //gets each letter of the clicked Tiles and adds it to a String variable 'current'
                    score+=(tile[j][k].getTile().value());    //gets the value of the tiles to calculate the score

                    tile[j][k].setForeground(Color.blue);
                    tile[j][k].removeActionListener(this);
                    tile[j][k].setEnabled(false); //the tile can only be clicked once

                    history.push(tile[j][k]);

                    // rest of the code to set rules for adjacent tiles etc
                }
            }
        }
    } 
    else if(choice.equals("Undo"))
    {
        Tile previous = history.pop(); //be sure to handle EmptyStackException 
        //TODO undo the actions of the Tile: subtract score, remote letter, enable the button
    }
    else if(choice.equals("Submit"))
    {
        //...
    }
    else if(choice.equals("Done"))
    {
        //...
    }
}