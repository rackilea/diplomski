private void processInput(String message){
    String[] commands=message.split(':');
    if(commands[0].equals("NAME")){
        clientName=commands[1];
    }
    else{
        tellEveryone(message);
    }
}