import java.awt.*; 
import javax.swing.*; 

public class ColorJPanel extends JPanel{ 
  public static final int CJP_WIDTH = 500;
  public static final int CJP_HEIGHT = 500;

  public ColorJPanel()  { 
    this.setBackground(Color.WHITE); 
    JButton arxikopoihsh = new JButton("Αρχικοποίκηση"); 
    JButton klhrwsh = new JButton("Κλήρωση"); 
    add(arxikopoihsh); 
    add(klhrwsh); 
  } 

  // let the component size itself
  public Dimension getPreferredSize() {
    return new Dimension(CJP_WIDTH, CJP_HEIGHT); 
  }
}