public class GUI4EX extends JFrame implements ActionListener{
  //... all other field
  DefaultListModel model;

  //constructor
  public GUI4EX(){
    //all other code
    //DefaultListModel model = new DefaultListModel(); instantiate the field instead
    model = new DefaultListModel();
    JList list = new JList(model);
    //rest of your code
  }
}