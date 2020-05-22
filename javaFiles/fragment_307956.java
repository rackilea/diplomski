JLabel label = new JLabel("Tab1");
label.setHorizontalTextPosition(JLabel.TRAILING); // Set the text position regarding its icon
label.setIcon(UIManager.getIcon("OptionPane.informationIcon"));

JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
tabbedPane.addTab(null, new JPanel());
tabbedPane.setTabComponentAt(0, label); // Here set the custom tab component