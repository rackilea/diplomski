table = new JTable();
    JScrollPane scrollPane = new JScrollPane(table);
    // table.setBounds(10, 304, 461, 189);
    scrollPane.setBounds(10, 304, 461, 189);  // This is bad, but will leave for now
    // frame.getContentPane().add(table);
    frame.getContentPane().add(scrollPane);