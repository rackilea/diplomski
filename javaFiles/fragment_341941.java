public class Login {
  //declare and instantiate a Client object
  static Client client = new Client();
 ....

  loginB.addActionListener(new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent e) {

            String username = usernameTF.getText();
            ClientGUI clientgui = new ClientGUI(username, 7777);
            clientgui.setVisible(true);
            try{
              // get the instantiated client
              System.out.println("Attempting connection for " + username +  
                "(client == null): " + (client == null ? "true" : "false"));

              // use the static variable
              client.connectClient(username);
            }
            catch(NullPointerException npe){
              npe.printStackTrace();
            }
    }

});
}