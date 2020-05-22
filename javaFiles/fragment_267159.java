JPanel rootPanel = new JPanel(new BorderLayout());
JPanel controlPanel = new JPanel(new FlowLayout());
controlPanel.add(new JButton("Alpha"));
controlPanel.add(new JButton("Beta"));
controlPanel.add(new JButton("Gamma"));
rootPanel.add(controlPanel, BorderLayout.NORTH);
rootPanel.add(myCanvas3D, BorderLayout.CENTER);