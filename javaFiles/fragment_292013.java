final JList list = new JList(GUI.strings.toArray());
JScrollPane scrollPane = new JScrollPane(list);

scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

getContentPane().add(scrollPane, BorderLayout.CENTER);