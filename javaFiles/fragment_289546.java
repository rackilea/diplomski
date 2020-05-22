import javax.swing.*; 

public class Main { 

  public static void main(String[] args) { 

    JFrame frame = new JFrame("Askhsh 3"); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    ColorJPanel application = new ColorJPanel(); 
    frame.add(application); 
    frame.pack();
    frame.setVisible(true); 
  } 
}