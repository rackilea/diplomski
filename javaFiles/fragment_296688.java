JPanel verticalPane = new JPanel();
verticalPane.setLayout(new BoxLayout(verticalPane, BoxLayout.Y_AXIS));

JScrollPane pane = new JScrollPane(verticalPane);

//add what you want to verticalPane
verticalPane.add(new JButton("foo"));
verticalPane.add(new JButton("bar"));