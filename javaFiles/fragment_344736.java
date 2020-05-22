JPanel p1 = new JPanel();
int x = getWidth();
int y = getHeight() * 0.25;
int y2 = getHeight() * 0.75;
p1.setPreferredSize(new Dimension(x, y);
p1.add(yourFirsPanel);

JPanel p2 = new JPanel();
p2.setPreferredSize(new Dimension(x, y2);

JPanel p3 = new JPanel(new BorderLayout());
p3.add(p1, BorderLayout(NORTH));
p3.add(p2, BorderLayout(CENTER));