JFrame fr = new JFrame("Testing window");
JTextField tf = new JTextField();
fr.add(tf, BorderLayout.CENTER);

fr.setVisible(true); //show the JFrame

Point p = tf.getLocation(); //get the coordinates