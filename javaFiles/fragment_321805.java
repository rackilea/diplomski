// your Panels
JPanel mainPanel = new JPanel();
JPanel subPanel = new JPanel();
mainPanel.setLayout(new GridBagLayout()); // use GridBagLayout with mainPanel
subPanel.setPreferredSize(new Dimension (0,165)); // use a preferred height for the subPanel
GridBagConstraints c = new GridBagConstraints(); // your gridBagLayout Constraints
c.fill = GridBagConstraints.HORIZONTAL; // stretch subPanel horizontal
c.weightx = 1.0; // with 100% of screen
mainPanel.add(subPanel,c); // add sub to mainPanel with the constraints