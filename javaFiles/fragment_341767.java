JFrame f = new JFrame();
f.setSize(500, 500);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JPanel total = new JPanel(new BorderLayout());
total.setSize(f.getWidth(), f.getHeight());
total.setBackground(Color.green);
total.setBorder(new EmptyBorder(100, 200, 100, 200));

JPanel box = new JPanel();
box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
box.add(new JButton("test"));
box.add(new JLabel("hey"));

total.add(box);
f.add(total);
f.setVisible(true);