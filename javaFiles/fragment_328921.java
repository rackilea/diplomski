import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.beans.*;
import java.util.Date;

public class CalculateSubTotal {

  private static JDateChooser checkin = new JDateChooser();
  private static JDateChooser checkout = new JDateChooser();
  private static JSpinner rooms = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));
  private static JTextField subTotal = new JTextField(20);
  private static JButton button = new JButton("Check availability");

  public static void main(String[] args) {

    checkin.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
        calculateSubTotal(checkin.getDate(), checkout.getDate(), (Integer) rooms.getValue(), 50);
      }
    });

    checkout.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
        calculateSubTotal(checkin.getDate(), checkout.getDate(), (Integer) rooms.getValue(), 50);
      }
    });

    rooms.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        calculateSubTotal(checkin.getDate(), checkout.getDate(), (Integer) rooms.getValue(), 50);
      }
    });

    button.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e) {
        calculateSubTotal(checkin.getDate(), checkout.getDate(), (Integer) rooms.getValue(), 50);
      }
    });

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().setLayout(new GridLayout(6, 2));
    f.getContentPane().add(new JLabel("Price"));
    f.getContentPane().add(new JLabel("50"));
    f.getContentPane().add(new JLabel("Check in"));
    f.getContentPane().add(checkin);
    f.getContentPane().add(new JLabel("Check out"));
    f.getContentPane().add(checkout);
    f.getContentPane().add(new JLabel("Number of rooms"));
    f.getContentPane().add(rooms);
    f.getContentPane().add(new JLabel("Sub total"));
    f.getContentPane().add(subTotal);
    f.getContentPane().add(button);
    f.setBounds(300, 200, 400, 300);
    f.setVisible(true);
  }

  private static void calculateSubTotal(Date checkin, Date checkout, int rooms, int price) {
    if (checkin == null || checkout == null) {
      return;
    }
    int sub = getDays(checkin, checkout) * rooms * price;
    subTotal.setText(String.valueOf(sub));
  }

  private static int getDays(Date checkin, Date checkout) {
    return (int) ((checkout.getTime() - checkin.getTime()) / (1000 * 60 * 60 * 24));
  }
}