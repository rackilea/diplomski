ShowImage panel = new ShowImage();
panel.setBackground(Color.RED);

setContentPane(new ContentPane());
getContentPane().setBackground(Color.BLACK);
setLayout(new BorderLayout());
add(panel);

JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
pnlButtons.setOpaque(false);
pnlButtons.add(new JButton("<<"));
pnlButtons.add(new JButton("<"));
pnlButtons.add(new JButton(">"));
pnlButtons.add(new JButton(">>"));

// Okay, in theory, getContentPane() is required, but better safe the sorry
getContentPane().add(pnlButtons, BorderLayout.SOUTH);

setVisible(true);