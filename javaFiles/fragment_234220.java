//   String state1 = state.getText();
//   int state2 = Integer.parseInt(state1);
//   String withdrawal1 = withdrawal.getText();
//   int withdrawal2 = Integer.parseInt(withdrawal1);
//   int finalState = state2 - withdrawal2;


private class newHandler implements ActionListener {
  ArrayList<String> first_names = new ArrayList<String>();
  ArrayList<String> last_names = new ArrayList<String>();

  public void actionPerformed(ActionEvent event) {

     // SHOWING THE FINAL MESSAGE BOX
     if (event.getSource() == accept) {

        String state1 = state.getText();
        int state2 = Integer.parseInt(state1);
        String withdrawal1 = withdrawal.getText();
        int withdrawal2 = Integer.parseInt(withdrawal1);
        int finalState = state2 - withdrawal2;

        JOptionPane.showMessageDialog(null, "Hello " + firstName.getText()
              + " " + lastName.getText() + " " + state.getText()
              + " .Your current account state is: " + finalState);
     }
  }
}