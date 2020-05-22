import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Test1 {

    public static void main(String args[]) {
        new Test1().addVehicle();
    }

    private void addVehicle() {
        System.out.println("Add Vehicle");
        String[] options = { "Private person", "Firm" };
        String[] vehicle = { "Car", "Truck", "MC" };
        String[] personDetails = { "Firstname: ", "Lastname: ",
                "Date of Birth: ", "Address: ", "Phone Number: " };

        int chooseOwnerType = JOptionPane.showOptionDialog(null,
                "Private person/firm", "Choose an option",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, "");
        int chooseVehicleType = JOptionPane.showOptionDialog(null,
                "What kind of vehicle is it?", "Choose and option",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                vehicle, "");
        int numPairs = personDetails.length;

        System.out.println("Owner Type:" + chooseOwnerType);
        System.out.println("Vehicle Type:" + chooseVehicleType);
        JPanel p = null;

        GridLayout gridLayout = new GridLayout(0,2);

            //Private Person
        if (chooseOwnerType == 0) {
            p = new JPanel(gridLayout);
            for (int i = 0; i < numPairs; i++) {
                JLabel l = new JLabel(personDetails[i], JLabel.TRAILING);
                p.add(l);
                JTextField textField = new JTextField(10);
                l.setLabelFor(textField);
                p.add(textField);
            }
        }

        if (chooseOwnerType == 1) {
        }

        if (p != null) {
            JFrame window = new JFrame("GUI Test");
            window.setContentPane(p);
            window.setSize(250, 100);
            window.setLocation(100, 100);
            window.setVisible(true);
            window.pack();
        }

    }

}