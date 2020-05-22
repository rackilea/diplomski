JPanel panel = new JPanel();
panel.setLayout(new GridBagLayout());
GridBagConstraints c;

JPanel left = new JPanel();
left.setBorder(BorderFactory.createTitledBorder("Left"));
c = new GridBagConstraints();
c.weightx = 1;
c.weighty = 1;
c.fill = c.BOTH;
panel.add(left, c);

JPanel right = new JPanel();
right.setBorder(BorderFactory.createTitledBorder("Right"));
c = new GridBagConstraints();
c.weightx = 2;
c.weighty = 1;
c.fill = c.BOTH;
panel.add(right, c);