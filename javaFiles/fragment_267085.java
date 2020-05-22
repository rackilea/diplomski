JPanel panel = new JPanel();

panel.setLayout(layout = new GridBagLayout());
layout.columnWidths = new int[9];
Arrays.fill(layout.columnWidths, 50);
layout.rowHeights = new int[9];
Arrays.fill(layout.rowHeights, 50);

panel.add(firstOperand, firstOperandConstraints);
panel.add(op1, op1Constraints);
panel.add(secondOperand, secondOperandConstraints); 
panel.add(op2, op2Constraints);   
panel.add(answer, answerConstraints);    
panel.add(ans, ansConstraints);
panel.add(plus, plusConstraints);
panel.add(mul, mulConstraints);

GridBagLayout rootLayout = new GridBagLayout();
rootLayout.columnWidths = new int[]{450};
rootLayout.rowHeights = new int[]{450};
con.setLayout(rootLayout);
con.add(panel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setMinimumSize(null); //To make sure the pack() directive doesn't result in a frame larger than the components
frame.pack();
frame.setMinimumSize(frame.getSize());
frame.setVisible(true);