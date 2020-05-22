setSize(new Dimension(1000, 600));
gameBoard = new JPanel();
gameBoard.setLayout(null);
gameBoard.setOpaque(false);
Dimension expectedDimension = new Dimension(920, 500);
gameBoard.setPreferredSize(expectedDimension);
gameBoard.setMaximumSize(expectedDimension);
gameBoard.setMinimumSize(expectedDimension);
//add cards to gameBoard here

JLabel background = new JLabel( new ImageIcon( getClass().getResource("images/graphic.png") ) );
background.setLocation(79,0); //manually center graphic
background.setBounds(new Rectangle(0, 0, 920, 500));
gameBoard.add(background);

Box centerBox = new Box(BoxLayout.Y_AXIS);
centerBox.setOpaque(true); 
centerBox.setBackground(Color.WHATEVER);
centerBox.add(Box.createVerticalGlue());
centerBox.add(gameBoard);
centerBox.add(Box.createVerticalGlue());
add(centerBox);
setVisible(true);