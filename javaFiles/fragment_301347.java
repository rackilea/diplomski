// this is a class field
private int count = 0;

// in the code where you create your GUI
button.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent evt){
    count++;  // increment count
    // do something with the button pressed, add information to a list
    secuenciaUsuarioGUI.add(/* ?? something ?? */);
    if (count == 3) {  
      // check the sequence
      comparaSecuencia(); // ?? maybe this
      count = 0; // reset
    }
  }
});