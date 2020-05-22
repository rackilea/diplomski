public DrawingBoardWithMatrix(){  
      Container c = getContentPane();
      c.add(new PaintSurface(), BorderLayout.CENTER);
      setResizable(false);      //put the code setResizable(false) before pack();
      pack();
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

  }

public PaintSurface() {
    this.setPreferredSize(new Dimension (600,600)); 
.....
}