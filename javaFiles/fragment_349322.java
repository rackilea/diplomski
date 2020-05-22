ActionListener ordermethod = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Hello");
    }
};

JPopupMenu popup = new JPopupMenu();

JMenuItem arr = new JMenuItem("first");
arr.addActionListener(ordermethod);
popup.add(arr);
arr = new JMenuItem("second");
arr.addActionListener(ordermethod);
popup.add(arr);
myPanel.add(new JLabel("Pattern ordering method:"), gbc);
myPanel.add(arr, gbc);