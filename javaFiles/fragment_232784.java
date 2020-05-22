import javax.swing.*;

public class BoxDemo {

    public static void main(String[] args) {
        Box box = Box.createVerticalBox();
        JCheckBox cbox1 = new JCheckBox("Check me once");
        JCheckBox cbox2 = new JCheckBox("Check me twice");
        JCheckBox cbox3 = new JCheckBox("Check me thrice");
        box.add(cbox1);
        box.add(cbox2);
        box.add(cbox3);
        JOptionPane.showMessageDialog(null, box);
    }
}