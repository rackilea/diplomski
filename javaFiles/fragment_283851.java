button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // SwingUtilities.invokeLater(() -> Test.showView(panel2)); // not needed
        Test.showView(panel2);
        Component[] comps = panel2.getComponents();
        if (comps.length > 0) {
            comps[0].requestFocusInWindow();
        }
    }
});