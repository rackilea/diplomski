jComboBox1.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
       jLabel4.setVisible(jComboBox1.getSelectedIndex() == 1);
    }
});