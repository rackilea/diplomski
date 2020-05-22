for (int j = 0; j < maxPointCount; j++) {
     x = someMethodToGetX(j);
     y = someMethodToGetY(j);
     double balance = PanelHeight - ((((double) y / maxY) * 
           Y_AXIS_LENGTH) + Y_AXIS_OFFSET);
     double weeks = (((double) x / maxX) * X_AXIS_LENGTH) + 
           X_AXIS_OFFSET;

     int xPos = (int) Math.round(weeks);
     int yPos = (int) Math.round(balance); 

     g2.setColor(Color.RED);
     g.drawOval(xPos, yPos, 2, 2);
  }