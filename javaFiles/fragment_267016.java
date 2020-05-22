JButton addButton1 = new JButton();
JButton deleteButton1 = new JButton();
JButton playButton1 = new JButton();
JButton addButton2 = new JButton();
JButton deleteButton2 = new JButton();
JButton playButton2 = new JButton();


JFrame frame = new JFrame();
frame.setLayout(new GridLayout(1, 2));

JPanel panel1 = new JPanel();
panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("List 1"));
JPanel panel2 = new JPanel();
panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("List 2"));

JPanel panel3 = new JPanel();
panel3.setLayout(new FlowLayout());
panel3.add(addButton1);
panel3.add(deleteButton1);
panel3.add(playButton1);
JPanel panel4 = new JPanel();
panel4.setLayout(new FlowLayout());
panel4.add(addButton2);
panel4.add(deleteButton2);
panel4.add(playButton2);

panel1.add(panel3);
panel2.add(panel4);

JScrollPane tableContainer1 = new JScrollPane(table1);
panel1.add(tableContainer1, BorderLayout.CENTER);
JScrollPane tableContainer2 = new JScrollPane(table2);
panel2.add(tableContainer2, BorderLayout.CENTER);



frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(new FlowLayout());

frame.getContentPane().add(panel1);
frame.getContentPane().add(panel2);

frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);