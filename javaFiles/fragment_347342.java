public class Layout extends JPanel implements ActionListener {
    public JButton BTN_werpen;

    public Layout() {
        BTN_werpen = new JButton("Werpen");
        BTN_werpen.setBounds(465, 10, 80, 30);
        BTN_werpen.addActionListener(this);
        P_velden.add(BTN_werpen);
    }

    @Override
    public void onActionPerformed(ActionEvent e) {
        if (e.getSource() == BTN_werpen) {
            // handle click
            BTN_werpen.setEnabled(false);
        }
    }