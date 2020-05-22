while(true){
    messages = is.readLine();
    System.out.println("From ResMesClient :  "+messages);
    if(!messages.equals("QUITCLIENT")) {
        SwingUtilities.invokeLater(new Runnable() {
           public void run() {
           cf.send(message); 
        }
    } else {

       //Quit programm or whatever
  }
});
}