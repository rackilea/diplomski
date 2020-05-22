import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class Main{
  public static void main(String[] args){
    // Create JComponents and add them to containers.
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    panel.setLayout(new BorderLayout());

    JTextArea jta = new JTextArea("Hello world!");
    panel.add(jta);
    frame.add(panel);

    // Modify some properties.
    jta.setRows(10);
    jta.setColumns(10);
    jta.setBackground(Color.RED);
    panel.setBorder(new EtchedBorder());

    // Display the Swing application.
    frame.setSize(200, 200);
    frame.setVisible(true);
  }
}