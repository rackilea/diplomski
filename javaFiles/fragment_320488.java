JPanel titlePanel=new JPanel(new GridLayout(1,2));
titlePanel.setBorder(new LineBorder(Color.BLACK));
titlePanel.setBackground(Color.LIGHT_GRAY);

JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
panel.setBackground(Color.LIGHT_GRAY);

titlePanel.add(new JLabel("Title",JLabel.LEFT));
panel.add(new JButton("X"));
titlePanel.add(panel);

frame.add(titlePanel, BorderLayout.NORTH);
// add panel in the north section of the undecorated JFrame 
// that by default uses BorderLayout