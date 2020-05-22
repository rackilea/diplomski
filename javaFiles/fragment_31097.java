JList<String> list = new JList<>();
list.setSelectedIndex(0);
list.setVisibleRowCount(3);
pain = new JScrollPane(list);

p3.add(pain, BorderLayout.SOUTH);

add(p3, BorderLayout.SOUTH);