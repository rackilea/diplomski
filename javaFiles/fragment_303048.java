UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
JFrame first = new JFrame("First");
first.add(new JButton("Click me, I look funny"));
first.setPreferredSize(new Dimension(300, 100));
first.pack();
first.setVisible(true);

UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

JFrame second = new JFrame("Second");
second.add(new JButton("Click"));
second.setPreferredSize(new Dimension(100, 100));
second.setLocation(300, 0);
second.pack();
second.setVisible(true);
second.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);