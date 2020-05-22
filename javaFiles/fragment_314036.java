public class thirdClass extends firstClass {

@Override
public void actionPerformed(ActionEvent event) {

    String string = "";

    if (event.getSource() == item1)
        string = String.format("field 1 inherited from first class babe : %s", event.getActionCommand());
    else if (event.getSource() == item2)
        string = String.format("field 2 inherited from first class babe : %s", event.getActionCommand());
    else if (event.getSource() == item3)
        string = String.format("field 3 inherited from first class babe : %s", event.getActionCommand());
    else if (event.getSource() == passwordField)
        string = String.format("Password Field inherited from first class babe  is : %s", event.getActionCommand());

    JOptionPane.showMessageDialog(null, string);


}