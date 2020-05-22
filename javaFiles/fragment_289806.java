// row variation

JPanel parent = new JPanel();
parent.setLayout(new GridLayout(3, 1));

parent.add(new JPanel()); // placeholder for 1st row

JPanel row = new JPanel(); // 2nd row
row.setLayout(new GridLayout(1, 3)); // create 3 cells of equal size

row.add(new JPanel()); // 2nd row, 1st cell placeholder

// now you have a 33% x 33% (oops) rectangle in the middle
JPanel controls = new JPanel();
controls.setLayout(new GridLayout(2, 1, 10, 10));
controls.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10);
controls.add(new JButton("Client"));
controls.add(new JButton("Server"));

row.add(controls); // add 2nd row, 2nd cell

row.add(new JPanel()); // 2nd row, 3rd cell placeholder

parent.add(row); // add 2nd row

parent.add(new JPanel()); // placeholder for 3rd row