JFrame f = new JFrame();
f.setSize(500, 500);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JPanel total = new JPanel();
total.setLayout(null);
total.setSize(f.getWidth(), f.getHeight());
total.setBackground(Color.green);

JPanel box = new JPanel();
box.setLocation(100, 200);
box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
box.add(new JButton("test"));
box.add(new JLabel("hey"));
box.setSize(100, 100);  // <-- Don't forget this..

total.add(box);
f.add(total);
f.setVisible(true);