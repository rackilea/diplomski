JButton newTabButton = new JButton("Add Tab");
newTabButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        JPanel newTab = new JPanel();
        newTab.setLayout(null);
        // Dynamic panel is a JTabbedPane
        dynamicPanel.addTab(JOptionPane.showInputDialog("Name of tab"), newTab);
    }
});