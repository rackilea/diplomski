JPanel panel = new JPanel(new GridBagLayout());
GridBagConstraints c = new GridBagConstraints();

c.gridx = x1;
c.gridy = y1;
JButton btn1 = new JButton("Smaller");
btn1.setPreferredSize(new Dimension(30, 20));
panel.add(btn1, c);

c.gridx = x2;
c.gridy = y2;
JButton btn2 = new JButton("Larger");
btn2.setPreferredSize(new Dimension(50, 40));
panel.add(btn1, c);