import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBox{
  JComboBox combo;
  JTextField txt;
  static ComboBox b1 = null;
  static ComboBox b2 = null;
  public static void main(String[] args) {
  b1 = new ComboBox();
  b2 = new ComboBox();
  }

  public ComboBox(){
  String course[] = {"BCA","MCA","PPC","CIC"};
  JFrame frame = new JFrame("Creating a JComboBox Component");
  JPanel panel = new JPanel();
  combo = new JComboBox(course);
  combo.setBackground(Color.gray);
  combo.setForeground(Color.red);
  txt = new JTextField(10);
  panel.add(combo);
  panel.add(txt);
  frame.add(panel);
  combo.addItemListener(new ItemListener(){
  public void itemStateChanged(ItemEvent ie){
  String str = (String)combo.getSelectedItem();
  b1.txt.setText(str);
  b2.txt.setText(str);
  }
  });
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(400,400);
  frame.setVisible(true);
  }
}