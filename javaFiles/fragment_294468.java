public Game(){
  JFrame frame = new JFrame();
  frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

  setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
  setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));

  //Not really necessary because of frame.pack()
  //setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));

  //You should add some elements here
  JPanel panel=new JPanel();
  panel.add(new JTextField(10));

  frame.add(panel);

  //Forces the frame to take the minimum-size to contain its elements
  frame.pack();
  frame.show();
}