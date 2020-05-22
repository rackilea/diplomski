import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Test {

  public static void main(String[] args) {
    EventQueue.invokeLater(new Cadre());
  }

  public static class Cadre extends JFrame implements Runnable {

//  private PanneauHaut panneauHaut;
//  private PanneauBas panneauBas;

    @Override
    public void run() {
      System.out.println("Thread started");
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//    setExtendedState(JFrame.MAXIMIZED_BOTH);
//    this.panneauHaut = new PanneauHaut();
//    this.panneauBas = new PanneauBas();
      JPanel mainPanel = new JPanel();
      JTextField kooltxt = new JTextField("hehehe");
      mainPanel.setLayout(new BorderLayout());
      mainPanel.add(kooltxt);
//    mainPanel.add(panneauHaut, BorderLayout.NORTH);
//    mainPanel.add(panneauBas.getPanel(), BorderLayout.SOUTH);
      this.setContentPane(mainPanel);
      pack();
      setLocationRelativeTo(null);
      this.setVisible(true);
    }
  }

}