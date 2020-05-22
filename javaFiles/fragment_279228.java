@Override
public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D) g;

    g2d.setColor(Color.BLACK);
    //draw rects
    for(int i=0; i<n; i++){
        //draw rects
        g2d.drawRect(x, y, width, height);
    }

    //fill rects
    for(int i=0; i<n i++){
        //set random color for blinking effect
        g2d.setColor(/*random color*/);
        g2d.fillRect(x, y, width, height);
    }

}