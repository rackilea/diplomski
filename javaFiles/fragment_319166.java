public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().matches("left"))
      System.out.print("left button pressed");
    else if(e.getActionCommand().matches("right"))
      System.out.print("right button pressed");
}