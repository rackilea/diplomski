public GUI()
{
  frame.setSize(835,650);
  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  //frame.setVisible(true);   // <<--- call it at the end of the code      
  frame.add(panel);
  //panel.setSize(600,600); <<--- removing set size

  panel.add(new DrawPlanes(300,300,200,Color.BLACK));
  frame.setVisible(true);
}