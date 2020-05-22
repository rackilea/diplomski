JPanel master = new JPanel();
master.add(all);
master.add(all2);

JScrollPane scroll = new JScrollPane(master);
scroll.setPreferredSize(new Dimension(100,100));
scroll.setViewportView(all);
scroll.setVisible(true);

fram.add(scroll);
fram.pack();
fram.setVisible(true);
fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);