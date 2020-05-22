private void setHandlers() {
    jButton2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            ((mainFrame) SwingUtilities.getWindowAncestor((Component)(e.getSource()))).showAlert();
        }
    });
}
public void showAlert() {
    JOptionPane.showConfirmDialog(this, "Confirming !!");
}