frame = new JFrame();
frame.setBounds(100, 100, 450, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JPanel panel = new JPanel();
panel.setLayout(new BorderLayout(0, 0));
JButton button = new JButton("I'm a button!");
panel.add(button);

frame.getContentPane().add(panel, BorderLayout.CENTER);