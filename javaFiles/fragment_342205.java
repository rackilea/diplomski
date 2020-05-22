switch(line){
case "playertable": 
    output.writeObject( positions );    
    break;
case "gamesettings": 
    output.writeObject( gameSettings );
    break;
default:
    // You should throw an exception or output an error message here
}