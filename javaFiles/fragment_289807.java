content.add(BoxLayout.createHorizntalGlue());

JPanel col = new JPanel();
col.setLayout(new BoxLayout(col, BoxLayout.PAGE_AXIS));
JButton clientBtn = new JButton("Client");
JButton serverBtn = new JButton("Server");
col.add(BoxLayout.createVerticalGlue());        
col.add(clientBtn);
col.add(BoxLayout.createRigidArea(new Dimension(1, 10)));
col.add(serverBtn);
col.add(BoxLayout.createVerticalGlue());
content.add(col);

content.add(BoxLayout.createHorizontalGlue());