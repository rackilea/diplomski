@Override
public void actionPerformed(ActionEvent e){
    //Assumes the map doesn't have any keys containing upper case letters.
    //By calling toLowerCase, if the user inputs "Red", it would still match
    //the key "red".
    String input = e.getActionCommand().toLowerCase();

    if(colorMap.containsKey(input){
        //...
    }    
}