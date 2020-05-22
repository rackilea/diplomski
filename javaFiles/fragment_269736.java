public class MetricConverter extends JFrame {

    private JPanel panel; //To reference a panel
    private JLabel messageLabel; //To reference a label
    private JTextArea kiloTextField; //To refrence a text field - this will become the JtextArea
    private JButton Previous;
    private JButton Menu;
    private JButton Load;
    private JButton Save;
    private JButton Next;
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 400;

    LinkedList ll = new LinkedList();//Created Linked List
    ArrayList al = new ArrayList();//Create an array list
    Iterator itr = al.iterator();
    ListIterator litr = al.listIterator();
    int previousIndex = 0; //<====================================Changes made here

    public MetricConverter() {
         //no changes were made here
    }

    /* The build panel label method adds a label, a text field, and a button to a panel    */
    private void buildPanel() {   //create the buttons
        //no changes were made here
    } //end buildPanel class

    private class Next implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String s = kiloTextField.getText();
            al.add(s);//add to array list
            litr = al.listIterator(); //<====================================Changes made here
            //ll.add(s);//add whatever is in the JtextArea to the linked list
            kiloTextField.setText(null);//"clear" the canvas

            //navigates to the last Object in the list
            while (litr.hasNext()) { //<====================================Changes made here
                litr.next();
            }
            //keeps track of where the cursor is
            previousIndex = litr.previousIndex();//<====================================Changes made here
        }
    }

    private class PrevButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String s = kiloTextField.getText();//
            //Object element = litr.previous();
            //System.out.print(element);
            //System.out.print(ll);
            //System.out.println("arr : "+al.toString());

            if (previousIndex > -1) { //<====================================Changes made here
                litr = al.listIterator(previousIndex+1);//sets the cursor to the previous object's index

                System.out.println(litr.previous());

                previousIndex--;
            }

        }
    }

    // Main Method          
    public static void main(String[] args) {
        new MetricConverter();
    }
}