JTextArea ta = new JTextArea(40, 20); // give columns and rows
JScrollPane scrollPane = new JScrollPane(ta);

JPanel borderLayoutPanel = new JPanel(new BorderLayout());
borderLayoutPanel.add(scrollPane, BorderLayout.CENTER);

JMenuBar menuBar = new JMenuBar();
// add menu's to the menu bar here

borderLayoutPanel.add(menuBar, BorderLayout.PAGE_START);