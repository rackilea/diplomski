Item[] items = ...// use your Items to populate Item to an array
JList itemList = new JList(items);

JScrollPane scrollPane = new JScrollPane(itemList);
scrollPane.setPreferredSize(new Dimension(300, 100)); //put your preferred size here

contentPane.add(scrollPane);