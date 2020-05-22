JTextArea jTextArea = new JTextArea(100,200);
jTextArea.setEditable(false);
jTextArea.setVisible(true);
//scrollPane_1.add(jTextArea);
jTextArea.append("Hello");

JScrollPane scrollPane_1 = new JScrollPane(jTextArea);
scrollPane_1.setBounds(0, 0, 672, 303);
panel_1.add(scrollPane_1);