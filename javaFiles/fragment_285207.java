JMenuItem item = new JMenuItem("Item1");
item.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Component component = frame.getFocusOwner();
        if (!(component instanceof JTextField)) {
            JOptionPane.showMessageDialog(frame, "Menu Item clicked");
        }
    }
});