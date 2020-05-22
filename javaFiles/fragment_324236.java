// Center the text in the JLabel using SwingConstants
private JLabel intLabel = new JLabel("Integer Calculation", SwingConstants.CENTER); 

// ...


public HW3TabbedPane() {
    // GridLayout to hold JPanels in one column and in several rows
    intPanel1.setLayout(new GridLayout(0, 1));
    intPanel1.add(intLabel);  // add the title JLabel to the top

    // next row's JPanel
    JPanel nextJPanel = new JPanel(); // leave it FlowLayout
    nextJPanel.add(n1IntLabel);
    nextJPanel.add(n1IntField);
    nextJPanel.add(n2IntLabel);
    nextJPanel.add(n2IntField);
    nextJPanel.add(intResultLabel);
    nextJPanel.add(intResultField);

    // add to the intPanel1
    intPanel1.add(nextJPanel);