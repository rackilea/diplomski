String tfg ;
  String tfc ;
  public void actionPerformed(ActionEvent e) {
    tfg = textField.getText();
    tfc = textField.getText();
    if(textField.getText().equals("0") || textField.getText().equals("") || textField.getText().equals(" ") || textField.getText().matches("[a-zA-Z]+")) {
      JOptionPane.showMessageDialog(Cow.this,
          "Tree Amount Should Be 1 or More",
          "Invalid Tree Amount",
          JOptionPane.ERROR_MESSAGE);
    }
    if(!tfg.equals("0")) {
      try {
        int tfgg = Integer.parseInt(tfc.trim());    // tfc = 4;
        int trcs = tfgg;                 // trcs = 4 * 1 = 5
        double trcp = 1.0 / 2;                 // trcp = 0.5
        int trcc = (int) (trcp * trcs);      // trcc = (0.5 * 5) = (2.5) = 2
        System.out.println("HI: "+trcc);
      } catch (NumberFormatException ignored) {
      }