for (int i = 0; i < jLabel.length; i++) {
    final String str = jLabel[i];
    JLabel labels = new JLabel(str);
    panel.add(labels);
    JButton button = new JButton(jButton[i]);
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(panel, str);
        }
    });
    panel.add(button);
}