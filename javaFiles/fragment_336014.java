import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class OverlaySampleAlignment0 {
  public static void main(String args[]) {
    JFrame frame = new JFrame("Overlay Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setPreferredSize(new Dimension(500,300));

    LayoutManager overlay = new OverlayLayout(panel);
    panel.setLayout(overlay);

    JTextField field = new JTextField("", 12);
    field.setMaximumSize(field.getPreferredSize());

    //button.setMaximumSize(new Dimension(25, 25));
    field.setBackground(Color.white);
    field.setAlignmentX(0.0f);
    field.setAlignmentY(0.0f);    
    panel.add(field);


    frame.add(panel);
    frame.setResizable(false);
    frame.pack();
    frame.setVisible(true);
  }
}