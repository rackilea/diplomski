JPanel contents = new JPanel(new BorderLayout());

JLabel carImage = new JLabel(icon);

contents.add(carImage, BorderLayout.NORTH);
contents.add(scrollPane, BorderLayout.CENTER);

JOptionPane.showMessageDialog(null, contents, "Inventory", JOptionPane.PLAIN_MESSAGE);