import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class CheckBoxFrame extends JFrame 
{

private final JComboBox<String> colorComboBox; 
private final JCheckBox backgroundColorCheckBox; 
private final JCheckBox foregroundColorCheckBox; 
private final JButton okButton;
private final JButton cancelButton;

private static final String[] color = {"Red", "Blue", "Green", "Purple"};

public CheckBoxFrame()
{
  super("ColorSelect");
  setLayout(new GridBagLayout());

  GridBagConstraints c = new GridBagConstraints();
  colorComboBox = new JComboBox<String>(color);
  c.fill = GridBagConstraints.HORIZONTAL;
  c.gridx = 0;
  c.gridy = 0;
  c.gridwidth = 2;
  add(colorComboBox, c);


  backgroundColorCheckBox = new JCheckBox("Background"); 
  c.fill = GridBagConstraints.HORIZONTAL;
  c.gridx = 0;
  c.gridy = 1;
  c.gridwidth = 1;
  add(backgroundColorCheckBox, c); // add bold checkbox to JFrame

  foregroundColorCheckBox = new JCheckBox("Foreground");
  c.fill = GridBagConstraints.HORIZONTAL;
  c.gridx = 1;
  c.gridy = 1;
  c.gridwidth = 1;
  add(foregroundColorCheckBox, c); // add italic checkbox to JFrame

  okButton = new JButton("Ok");
  c.fill = GridBagConstraints.HORIZONTAL;
  c.gridx = 0;
  c.gridy = 2;
  c.gridwidth = 1;
  add(okButton, c);

  cancelButton = new JButton("Cancel");
  c.fill = GridBagConstraints.HORIZONTAL;
  c.gridx = 1;
  c.gridy = 2;
  c.gridwidth = 1;
  add(cancelButton, c);


  // register listeners for JCheckBoxes
  CheckBoxHandler handler = new CheckBoxHandler();
  backgroundColorCheckBox.addItemListener(handler);
  foregroundColorCheckBox.addItemListener(handler);
  } 


private class CheckBoxHandler implements ItemListener 
{
  // respond to checkbox events
  @Override
  public void itemStateChanged(ItemEvent event)
  {

  } 
 }
} // end class CheckBoxFrame