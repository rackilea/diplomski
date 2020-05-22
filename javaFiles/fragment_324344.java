String[] dummyList  = new String[] {
    "Val 1",
    "Val 2"
};
JPanel migPanel = new JPanel(new MigLayout("center, filly")); //Maybe you wanted center, center. I'm not sure
migPanel.add(new JLabel("Header"), "span, align center");
migPanel.add(new JTextField("Input"), "split 4");
migPanel.add(new JComboBox<String>(dummyList));
migPanel.add(new JLabel("To"), "span");
migPanel.add(new JComboBox<String>(dummyList), "wrap");
migPanel.add(new JButton("Convert"), "span, align center");
migPanel.add(new JTextField("Output"), "span, align center");