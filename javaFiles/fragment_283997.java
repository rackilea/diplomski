if(tile[j][k]==e.getSource())
 {
     ...
     history.push(tile[j][k]);
     ...
 }

 if(choice.equals("Undo"))
 {
     Tile previous = history.pop(); //be sure to handle EmptyStackException 
     //TODO undo the actions of the Tile: subtract score, remote letter, enable the button
 }