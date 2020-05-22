/*Note This code works but if initial condition when you execute the code it will throw exception the the code works  
 Sorry but I don't know much about swing
*/
package com;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class SwingTest 
{
    public static void main(String[] args) 
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new SimpleFTF());
        f.pack();
        f.setVisible(true);
    }
    public static class SimpleFTF extends JPanel 
    {            
        public SimpleFTF()
        {
            JFormattedTextField field = new JFormattedTextField("    ");  
           field.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    modify();   
                }
                @Override
                public void removeUpdate(DocumentEvent e) { 
                }
                @Override
                public void changedUpdate(DocumentEvent e) {                       
                }
                public void modify()
                {
                    String text=field.getText();
                    if(text.contains("\n"))
                        text=text.replaceAll("\n", "");
                        text=text.trim();
                        field.setText(text);
                }
            });                    
            add(field, java.awt.BorderLayout.CENTER);            
        }
    }
}