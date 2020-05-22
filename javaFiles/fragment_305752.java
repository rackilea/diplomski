import java.util.ArrayList;

import javax.swing.JOptionPane;

class Contacts {

    public static void main(String[] args) {
        String name;
        // contact number
        String number;

        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> numberList = new ArrayList<String>();

        while (true) {
            name = JOptionPane
                    .showInputDialog("What is the Contact's Full Name? Press cancle to exit");

            if (name == null) {// terminate loop if name is not provided
                break;
            }
            number = JOptionPane
                    .showInputDialog("What is the Contact's Phone Number? Press cancle to exit");

            if (number == null) {// terminate loop if number is not provided
                break;
            }

            nameList.add(name);
            numberList.add(number);

            JOptionPane.showMessageDialog(null, "Contact Added!");

            System.out.print("\nContact List");
            System.out.println();
            for (int i = 0; i < nameList.size(); i++) {
                System.out.println("--------------------------------");
                System.out.println(nameList.get(i) + "   " + "   "
                        + numberList.get(i));
            }
        }
    }
}