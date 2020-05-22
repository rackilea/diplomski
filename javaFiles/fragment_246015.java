import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoFrames
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Frame");

    JLabel label = new JLabel("No date selected");

    JButton button = new JButton("Open date dialog");
    button.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        DateDialog dateDialog = new DateDialog(frame);
        dateDialog.setLocationRelativeTo(frame);
        dateDialog.setVisible(true);
        label.setText(dateDialog.getDate());
      }
    });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(label, BorderLayout.CENTER);
    frame.getContentPane().add(button, BorderLayout.SOUTH);
    frame.setBounds(300, 200, 400, 300);
    frame.setVisible(true);
  }
}

class DateDialog extends JDialog
{
  private String date;

  DateDialog(Frame owner)
  {
    super(owner, "Select date", true);
    JTextField dateField = new JTextField(20);

    JButton okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        date = dateField.getText();
        setVisible(false);
      }
    });

    getContentPane().add(dateField, BorderLayout.CENTER);
    getContentPane().add(okButton, BorderLayout.SOUTH);
    setSize(300, 200);
  }

  String getDate()
  {
    return date;
  }
}