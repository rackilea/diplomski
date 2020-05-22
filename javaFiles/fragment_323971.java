import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class TextArea1{
    JTextArea text;
    JFrame frame;
    JTextField textField;
    public int k;
    public ArrayList aList;
    public String correctAnswer;

    public static void main (String [] args) {
        TextArea1 gui = new TextArea1();

        gui.go();
    }
    private String textLine;

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        textField = new JTextField("");
        JButton startButton  = new JButton ("Start!");
        startButton.addActionListener(new startButtonListener());


        text = new JTextArea (30, 60);
        text.setLineWrap(true);

        JScrollPane scroller = new JScrollPane(text);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scroller);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.WEST, startButton);
        frame.getContentPane().add(BorderLayout.SOUTH, textField);      
        frame.setSize(350, 300);
        frame.setVisible(true);
    }       

    class startButtonListener implements ActionListener {
     ArrayList aList;
        public void actionPerformed(ActionEvent event) {
            String fileName = "test.txt";
            String line;
            ArrayList <String>aList = new ArrayList<>();

            try {
                 try (BufferedReader input = new BufferedReader (new FileReader(fileName))) {
                     if (!input.ready())   {
                         throw new IOException();

                     }

                     while ((line = input.readLine()) !=null) {
                         aList.add(line);
                     }
                }
            } catch (IOException e) {
                System.out.println(e);

            }
            int sz = aList.size();
            boolean result=false;
            for(String t:aList){ 
            if (t.equalsIgnoreCase(textField.getText())) {
                    JOptionPane.showMessageDialog(null, "Hooray! Loading File contents....");
                    int count=0;
                    for (int k = 0; k< sz; k++) {          
                        text.append(aList.get(k).toString());
                        System.out.println(count);
                        count++;
                        // if(k<sz-1)
                        //  text.append(", ");
                        text.append("\n");
                    }
                    result=true;
                    break;
                 }

                 else {
                    result=false;
                 }
            }
            if(!result){
                JOptionPane.showMessageDialog(null, "Wrong!");
            }
        }
    }       
}