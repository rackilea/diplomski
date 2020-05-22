actionPerformed(ActionEvent e) { 
  if(e.getSource() instanceof JButton) {
    //Casting here is safe after the if condition
    JButton b = (JButton) e.getSource();
    System.out.println(b.getText());
  } else {
    System.out.println("Something other than a JButton was clicked");
  }
}