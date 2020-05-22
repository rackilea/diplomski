JFrame f = new JFrame();
JPanel p = new JPanel();
ComparisonPanel cp = new ComparisonPanel(); //jPanel with a few elements
ComparisonPanel cp2 = new ComparisonPanel();

p.setLayout(new FlowLayout()/*new GridLayout(2, 2)*/);

p.add(cp);
p. add(cp2);
f.getContentPane().add(p);
f.pack();
f.setVisible(true);