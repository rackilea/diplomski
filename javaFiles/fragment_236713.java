JFrame frame = new DisplayImage (); 
frame.setTitle("Go Bearcats!");
frame.setSize(300, 300);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
Assignment02 a = new Assignment02();
frame.add(a);  // here you add something on top of your imagePanel