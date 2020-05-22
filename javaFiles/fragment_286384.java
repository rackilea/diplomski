import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class Demo {

   private void initGUI(){

       final JButton button = new JButton("Hello!");
       button.setVisible(false);

       final JLabel testLabel = new JLabel("Welcome!");
       testLabel.setPreferredSize(new Dimension(200, 30));
       testLabel.setBorder(new LineBorder(Color.GRAY, 1));
       testLabel.setLayout(new BorderLayout());
       testLabel.add(button, BorderLayout.EAST);

       button.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseExited(MouseEvent e) {
               Point mousePosition = MouseInfo.getPointerInfo().getLocation();
               if(testLabel.contains(mousePosition)){
                   testLabel.dispatchEvent(new MouseEvent(testLabel, MouseEvent.MOUSE_ENTERED, System.currentTimeMillis(), 0, mousePosition.x, mousePosition.y, 0, false));
               } else {
                   testLabel.dispatchEvent(new MouseEvent(testLabel, MouseEvent.MOUSE_EXITED, System.currentTimeMillis(), 0, mousePosition.x, mousePosition.y, 0, false));
               }
           }

       });

       button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null, "The button was pressed!");
               Point mousePosition = MouseInfo.getPointerInfo().getLocation();
               testLabel.dispatchEvent(new MouseEvent(testLabel, MouseEvent.MOUSE_EXITED, System.currentTimeMillis(), 0, mousePosition.x, mousePosition.y, 0, false));
           }
       });

       testLabel.addMouseListener(new MouseAdapter(){
           @Override
           public void mouseEntered(MouseEvent e) {
               JLabel label = (JLabel) e.getSource();
               label.setText("Here is the Button!");
               button.setVisible(true);
           }

           @Override
           public void mouseExited(MouseEvent e) {
               Point point = e.getPoint();
               point.setLocation(point.x - button.getX(), point.y - button.getY()); //make the point relative to the button's location
               if(!button.contains(point)) {
                   JLabel label = (JLabel) e.getSource();
                   label.setText("The button is gone!");
                   button.setVisible(false);
               }
           }
       }); 

       JPanel content = new JPanel(new FlowLayout());
       content.setPreferredSize(new Dimension(300,100));
       content.add(testLabel);

       JFrame frame = new JFrame("Demo");
       frame.setContentPane(content);
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.pack();
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);

   }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().initGUI();
            }
        });
    }    

}