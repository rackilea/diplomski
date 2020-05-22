String[] options = new String[] {"Go ahead", "Go back", "Go forward", "close me"};
int option =  JOptionPane.showOptionDialog(null, "Title", "Message", 
      JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
      null, options, options[0]);

if (option != JOptionPane.CLOSED_OPTION) {
  System.out.println(options[option]);
} else {
  System.out.println("No option selected".);
}