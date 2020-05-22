JPanel panel = new JPanel(new BorderLayout());
    String[] columnNames = {"A", "B", "C", "D", "E"};
    Object[][] data = new Object[20][columnNames.length];
    for (int i = 0; i < 20; i++) {
        data[i] = new Object[]{"Some other stuff that is long", "K", "1234567891011121314", "R", "T"};
    }

    JTable skillTable = new JTable(data, columnNames);
    skillTable.setFillsViewportHeight(true);
    JScrollPane scrollTable = new JScrollPane(skillTable);
    panel.add(scrollTable, BorderLayout.CENTER);

    //as you said you want to add a button as well
    JPanel buttonpanel=new JPanel();
    buttonpanel.add(new JButton("Test"));
    panel.add(buttonpanel,BorderLayout.SOUTH);