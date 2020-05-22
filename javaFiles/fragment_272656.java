JPanel pnl = new JPanel();
pnl.setPreferredSize(new Dimension(500, 500));
JLabel lbl = new JLabel("label", SwingConstants.CENTER); //Set text align
pnl.setLayout(new BorderLayout());
pnl.add(lbl, BorderLayout.SOUTH);
lbl.setBackground(Color.red);
lbl.setOpaque(true); //Test background
getContentPane().add(pnl);