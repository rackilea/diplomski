frame.add(game); // Look and me, I'm in the CENTER
but = new JButton("Button");
frame.add(but, BorderLayout.SOUTH);
frame.pack();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setResizable(false);
frame.setLocationRelativeTo(null);
frame.setVisible(true);