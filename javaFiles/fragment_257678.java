JTabbedPane tabbedPanel = new JTabbedPane(); // holds all tabs

// this is how you add a tab:
JPanel somePanel = new JPanel();
tabbedPanel.addtab("Some Tab", somePanel);

// this is how you'd add your party screen
JPanel partyScreen = new JPanel();
tabbedPanel.addTab("Party Screen", partyScreen);