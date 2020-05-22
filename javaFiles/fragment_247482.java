public JTabbedPane tabbedPane() {
    UIManager.put("TabbedPane.selected", Color.ORANGE);
    mainJTP = new JTabbedPane();
    mainJTP.setBackground(Color.WHITE);
    mainJTP.setBounds(3, 1, 630, 500);
    mainJTP.addTab("Classic", classic());
    mainJTP.addTab("Deluxe", deluxe());
    mainJTP.addTab("Presidential", presidential());
    rooms();  // I've inserted this, no panic!
    return mainJTP;
}