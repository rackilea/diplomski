import java.awt.*;
import javax.swing.*;


public class AddingWindow extends JPanel {

AddingWindow() {

JPanel addingPanel = new JPanel(); 
addingPanel.setLayout(new GridLayout(2, 2));

JLabel fullNameLbl = new JLabel("Name");
JTextField fullNameTextField = new JTextField(25);
JButton addBtn  = new JButton("add");
JButton cancelBtn  = new JButton("cancel");

//Adding buttons, label and textfield to addingPanel
addingPanel.add(fullNameLbl);
addingPanel.add(fullNameTextField);
addingPanel.add(addBtn);
addingPanel.add(cancelBtn);                   
add(addingPanel);
    }
  }