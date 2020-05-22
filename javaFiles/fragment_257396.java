private int x;
private int y;

public void paintComponent(Graphics g) {
     super.paintComponent(g);  
     g.setColor(Color.BLUE);


     // RECT_WIDTH etc are constants
     g.drawRect(x, y, RECT_WIDTH, RECT_HEIGHT);
}


public void actionPerformed(ActionEvent e) { 
    int width = getWidth();             
    int height = getHeight();

    // code here to change the object's state -- here to change
    // location of the rectangle
    x++;
    y++;

    // TODO: check that x and y are not beyond bounds and if so,
    // then re-position them

    repaint();
}