public static void main(String args[]){
  JLabel someVariable = createImage("dump.jpg");
  JLabel anotherVariable = createImage("dump2.jpg");
}

public static JLabel createImage(String imgName){
  return new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/"+imgName))));
}