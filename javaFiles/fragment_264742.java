JScrollPane scrollPane = new JScrollPane();
//scrollPane.setBounds(402, 211, 178, 193);  // Don't do this!
frame.getContentPane().add(scrollPane);

JPanel panel = new JPanel();
scrollPane.setViewportView(panel);
//panel.setLayout(null);                     // Use a Layout Manager

JTextPane textPane_branding = new JTextPane();
textPane_branding.setPreferredSize(new Dimension(78,191));
//textPane_branding.setBounds(98, 0, 78, 191);
panel.add(textPane_branding);

JTextPane textPane_trunk = new JTextPane();
textPane_trunk.setPreferredSize(new Dimension(88,191));
//textPane_trunk.setBounds(0, 0, 88, 191);
panel.add(textPane_trunk);