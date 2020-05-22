package carpark;


import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.util.HashMap;

public class textBox extends javax.swing.JFrame 
implements ActionListener 
  { // declare the components and variables 
  private final JLabel inputLabel,inputLabel2,inputLabel3,countLabel; 
  private final JTextField inputBox,inputBox2,inputBox3,countBox; 
  private final JButton enterButton; 
  private final JButton clearButton;

  private int count; 
  private String sum; 
  private String inputString, countString; 
  private String sumString; 
  private HashMap<String, Integer> countMap;

  public textBox() 
    { // sets up the components and places them 
    this.setLayout(new FlowLayout()); 
    this.inputLabel = new JLabel("Please enter the vehicle's registration number:"); 
    this.inputBox = new JTextField(8); 
    this.inputLabel2 = new JLabel("Is this a high-value car? Enter yes or no:"); 
    this.inputBox2 = new JTextField(4); 
    this.inputLabel3 = new JLabel("Is this a large vehicle? Enter yes or no:"); 
    this.inputBox3 = new JTextField(4); 
    this.countLabel = new JLabel(" Car Count"); 
    this.countBox = new JTextField(3); 
    this.enterButton = new JButton("Enter"); 
    this.clearButton = new JButton("Clear"); 
    this.countMap = new HashMap<String, Integer>();
    this.add(inputLabel); 
    this.add(inputBox); 
    this.add(inputLabel2); 
    this.add(inputBox2); 
    this.add(inputLabel3); 
    this.add(inputBox3); 
    this.inputBox.addActionListener(this); 
    this.add(countLabel); 
    this.add(countBox); 
    this.countBox.setEditable(false); 


    this.add(enterButton); 
    this.enterButton.addActionListener(this); 
    this.add(clearButton); 
    this.clearButton.addActionListener(this); 
    } 

    public void actionPerformed(ActionEvent event) 
      { // reacts to the ENTER key being pressed 
      if (event.getSource() == this.enterButton || event.getSource() == this.inputBox) 
      try 
       { 
       this.inputString = inputBox.getText();  
       //If the hashmap does not contain the key, increment the count and put the registration number as the key into it.
       if(!this.countMap.containsKey(this.inputString)) {
            this.count += 1;
            this.countMap.put(this.inputString, 1);
       }
       //Else you can increment the count in the hashmap.
       this.countString = Integer.toString(this.count); 
       this.countBox.setText(this.countString); 
       } 

       catch (NumberFormatException entry) 
       { 
         this.inputBox.setText(""); 
       } 
       else if (event.getSource() == this.clearButton) 
       { 
        this.inputBox.setText(""); 
        this.countBox.setText("");  
        this.count = 0; 
        }  
      } 
  }