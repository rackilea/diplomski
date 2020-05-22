closeBtn = new JLabel(" X");
closeBtn = setUpBtn(closeBtn);
minBtn = new JLabel(" - ");
minBtn = setUpBtn(minBtn);
topText = new JLabel("test");
topText = setUpBtn(topText);
centText = setUpBtn(new JLabel("0%"));
setLayout(new GridBagLayout());
GridBagConstraints con = new GridBagConstraints();

setBackground(Color.black);

con.weightx = 0.7;
con.fill = GridBagConstraints.HORIZONTAL;
con.gridx = 0;
con.gridy = 0;
add(topText, con);

con.weightx = 1;
con.gridx = 1;
add(centText, con);

con.weightx = 0;
con.gridx = 2;
add(minBtn, con);

con.gridx = 3;
add(closeBtn, con);