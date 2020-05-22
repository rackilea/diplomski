import java.awt.GridLayout;

  import javax.swing.ImageIcon;
  import javax.swing.JFrame;
  import javax.swing.JLabel;
  import javax.swing.JPanel;
  import javax.swing.SwingUtilities;

  public class SimpleFrameTest2 extends JFrame {

      public SimpleFrameTest2() {

           setSize(500, 500);
           setTitle("Test");
           setDefaultCloseOperation(EXIT_ON_CLOSE);
           setLocationRelativeTo(null);
           setResizable(true);

           initComponents();

           setVisible(true);

       }

       private void initComponents() {

           JPanel panel = new JPanel();
           panel.setLayout(new GridLayout(5, 5, 0, 5));

           ImageIcon seat_icon = new ImageIcon("C:\\Users\\Ricardo\\Pictures\\referencias\\seating-chart.png");

           for (int i = 0; i < 25; i++) {
                //panel.add(new JLabel("" + i, seat_icon, JLabel.CENTER));
                panel.add(new Seat(i, i, seat_icon));
            }

            add(panel);

       }


       public static void main(String args[]){

            SwingUtilities.invokeLater(new Runnable() {
                 public void run() {
                     new SimpleFrameTest2();
                 }
            });   

        }  

     }