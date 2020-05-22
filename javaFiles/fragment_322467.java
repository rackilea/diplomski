import javax.swing.JFrame;

public class MainPanel {

  /** A Start point of the BC UI Clien Application. */
  public static void main(String[] args) {
    try {

        JFrame objLoginPane = new JFrame();
        objLoginPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        objLoginPane.pack();
        objLoginPane.show();
    } catch (Throwable ex) {
        ex.printStackTrace();
    }
  }    
}