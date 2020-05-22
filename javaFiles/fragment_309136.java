JFrame frame = new JFrame();
  //add layout manager. You can achieve the desired layout 
  //with GridLayout, Box layout and others 
  frame.getContentPane().setLayout(new GridLayout(1,2));
  GreenPanel greenPanel = new GreenPanel();
  //set preferred size to the panel 
  greenPanel.setPreferredSize(new Dimension(100,100));
  frame.add(greenPanel);
  BluePanel bluePanel = new BluePanel();
  //set preferred size to the panel 
  bluePanel.setPreferredSize(new Dimension(100,100));
  frame.getContentPane().add(bluePanel);

  //let the frame adapt to the panels size 
  //frame.setSize(500, 350); 
  frame.validate();
  frame.pack();
  frame.setVisible(true);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);