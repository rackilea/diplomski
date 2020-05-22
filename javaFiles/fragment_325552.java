public class Otherhandlerclass implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        dispose();
        JOptionPane.showMessageDialog(null, "Since you pressed that button, I will open a new window when you press ok, okay?");

        sinceyoupressedthecoolbutton();
    }

    public void sinceyoupressedthecoolbutton() {

        JDialog YES = new JDialog();
        JLabel label = new JLabel("Here is that new window I promised you!");
        YES.add(label);
        YES.setSize(500, 500);
        YES.setVisible(true);

    }

    public class okay implements ActionListener {

        public void actionPerformed(ActionEvent ok) {

        }

    }

}