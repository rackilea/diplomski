import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SwingSample {

    private JFrame frame;

     /**
      * Launch the application.
     */
    public static void main(String[] args) {
         EventQueue.invokeLater(new Runnable() {
              public void run() {
                 try {
                      SwingSample window = new SwingSample();
                      window.frame.setVisible(true);
                 } catch (Exception e) {
                      e.printStackTrace();
                 }
              }
         });
    }

    /**
     * Create the application.
    */
    public SwingSample() {
       initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,2));

        // create the first list
        String[] data = {"one", "two", "three", "four"};
        JList firstList = new JList(data);
        frame.add(firstList);

        // create the second list
        String[] numbers = {"1", "2", "invisible", "4"};
        JList secondList = new JList(numbers);
        frame.add(secondList);
        // the listener
        myListListener listener = new myListListener(firstList);
        secondList.addListSelectionListener(listener);
    }
}

class myListListener implements ListSelectionListener{

    private JList jlist;
    public myListListener(JList value){
       this.jlist = value;
    }

    public void valueChanged(ListSelectionEvent e) {

        boolean adjust = e.getValueIsAdjusting();
        if(!adjust){
          // get the selected value
          String value = (String)((JList)e.getSource()).getSelectedValue();

          // if condition is accomplished make the second list invisible
          if(value.equals("invisible")){
             jlist.setVisible(false);
          }
          else{
             jlist.setVisible(true);    
          }
        }
    }
}