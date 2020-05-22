public void run(){
    gg.frameGen(); 
    //...
    serverpc.validate(command.getText());
    String commandMessage = command.getText();
    serverSend.run(commandMessage);

}