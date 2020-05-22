jBUtton.addActionListener(new ActionListener() { 
  public void actionPerformed(ActionEvent e) { 
    System.out.println("Button Pressed");
    //pressed = !pressed; // if you want to toggle
    pressed = true;
    this.repaint(); // you need to refresh the screen 
  } 
} );