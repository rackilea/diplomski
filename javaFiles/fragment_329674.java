JFrame frame = new JFrame();
JPanel panel = new 

DefaultListModel model = new DefaultListModel();
model.add(0, "Item 0");
model.add(1, "Item 1");

JList list = new JList(model);

frame.add(panel);
panel.add(list);

frame.setVisible(true);

model.remove(0);
model.add(1, "Item 234");