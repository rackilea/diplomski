pnlTop.setBackground(Color.WHITE);
pnlBottom.setBackground(Color.BLUE);

// Because you don't want the bottom panel scale, you need to give it a height.
// Because you want the bottom panel scale x, you can give it any width as the
// layout manager will ignore it.
pnlBottom.setPreferredSize(new Dimension(1, 20));


getContentPane().setLayout(new GridBagLayout());
GridBagConstraints cst = new GridBagConstraints();
cst.fill = GridBagConstraints.BOTH;
cst.gridx = 0;
cst.gridy = 0;
cst.weightx = 1.0; // --> You miss this for the top panel
cst.weighty = 1.0;
getContentPane().add(pnlTop, cst);

cst = new GridBagConstraints();
cst.fill = GridBagConstraints.HORIZONTAL;
cst.gridx = 0;
cst.gridy = 1;
cst.weightx = 1.0; // You miss this for the bottom panel
cst.weighty = 0.0;
getContentPane().add(pnlBottom, cst);