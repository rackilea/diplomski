JTextArea jta = new JTextArea(20, 50);   <--- rows, and character columns
jta.setLineWrap(true);
jta.setWrapStyleWord(true);
JScrollPane scroll = new JScrollPane(jta);

container.add(scroll);  <--- make sure you don add jta anywhere else