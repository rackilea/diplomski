setLayout(new BorderLayout());
JPanel bottom = new JPanel();
bottom.setLayout(new BorderLayout());
bottom.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
bottom.add(new JPanel(), BorderLayout.CENTER);
bottom.add(cancel, BorderLayout.EAST);
add(new JPanel(), BorderLayout.CENTER);
add(bottom, BorderLayout.SOUTH);