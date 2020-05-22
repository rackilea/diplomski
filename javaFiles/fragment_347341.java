public class WerpButton extends JButton implements ActionListener {
    public WerpButton() {
        this.addActionListener(this);
    }

    @Override
    public void onActionPerformed(ActionEvent e) {
        this.setEnabled(false);
    }
}