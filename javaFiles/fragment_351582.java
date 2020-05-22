JFrame frame = new JFrame("Koch Snowflakes");
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setBounds(0,0, 600, 425);
frame.setBackground(Color.BLACK);
frame.setResizable(false);
frame.setLayout(new BorderLayout());

JPanel buttons = new JPanel(new FlowLayout());
buttons.add(new JButton("MENU"));
buttons.add(new JButton("DRAW"));
frame.add(buttons, BorderLayout.SOUTH);

JPanel drawArea = new JPanel();
drawArea.setBackground(Color.BLUE);
frame.add(drawArea, BorderLayout.CENTER);
frame.setVisible(true);
Dimension drawAreaDim = drawArea.getSize();
System.out.println(drawAreaDim);