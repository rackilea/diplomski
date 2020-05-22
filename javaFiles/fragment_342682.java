import java.awt.*;
import javax.swing.*;

public class app extends JFrame{
  public app(String title){
    super(title);

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    getContentPane().setLayout(layout);
    constraints.anchor = GridBagConstraints.WEST;
    JLabel l1 = new JLabel("First Name:");
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    constraints.weightx = 0;
    constraints.weighty = 0;
    constraints.fill = GridBagConstraints.BOTH;
    constraints.insets = new Insets(5,5,5,5);    
    layout.setConstraints(l1, constraints);
    getContentPane().add(l1);

    //JTextField t1 = new JTextField(10);
    JTextField t1 = new JTextField(); //removed passing column size.
    constraints.gridx = 1;
    constraints.gridy = 0;
    constraints.weightx = 1;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.insets = new Insets(5,5,5,5);
    layout.setConstraints(t1, constraints);
    getContentPane().add(t1);


    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(700,500);
  }
  public static void main(String[] args){
    new app("App").setVisible(true);
  }
}