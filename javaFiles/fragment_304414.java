...
Items items = service.getItems();
...

String itemContent = items.toString(); // you have to put meaningful information from class Items to this String
JTextArea itemDisplay = new JTextArea(itemContent);
// JTextField itemDisplay = new JTextField(itemContent);

JScrollPane scrollPane = new JScrollPane(textArea);
scrollPane.setPreferredSize(new Dimension(300, 100)); //put your preferred size here

contentPane.add(scrollPane);