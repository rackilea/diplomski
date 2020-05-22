b1 = new JButton("Button!");
b1.setVisible(true);
b2 = new JButton("Button 2!");
b2.setVisible(true);
r1.setVisible(true);
r.setVisible(true);
//setting grid numbers
c.gridx = 0;
c.gridy = 0;
c.gridwidth = 5;
c.gridheight = 2;

//adding to frame
p.add(b2,c);
c = new GridBagConstraints();
//setting grid numbers
c.gridx = 5;
c.gridy = 2;
p.add(r1,c);
....