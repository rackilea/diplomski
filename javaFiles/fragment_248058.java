Scanner fileScan = new Scanner (new File("1.txt"));
  boolean found = false; // added this variable
  while (fileScan.hasNextLine()) {
    String input = fileScan.nextLine();
    String Username = input.substring(0,input.indexOf(' '));
    String Password = input.substring(input.indexOf(' '),input.length());

    if (Username.equals(inputusername) || (Password.equals(inputpassword))) {
      found = true; // added this to set found
      getContentPane().removeAll();
      getContentPane().add(panel3);//Adding to content pane, not to Frame
      repaint();
      printAll(getGraphics());
    } // removed the else statement
  }

  if(!found) { // added the contents of the previously existing else statement here, outside the while
    JOptionPane.showMessageDialog(null,
      "Invalid password. Try again.",
      "Error Message",
      JOptionPane.ERROR_MESSAGE);
  }