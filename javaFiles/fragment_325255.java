int newX = (int) (Math.random() * (canvasMaxWidth - canvasMinWidth)) + canvasMinWidth;
int newY = (int) (Math.random() * (canvasMaxHeight - canvasMinHeight)) + canvasMinHeight;
Point point = new Point(newX, newY);
coordinates.add(point);
counter++;

redList.add((int) (Math.random() * 255));
greenList.add((int) (Math.random() * 255));
blueList.add((int) (Math.random() * 255));

 g.setColor(new Color(205,133,63));
 g.fillOval(canvasMinWidth,canvasMinHeight,400,400); 



 for(int z = 0; z < coordinates.size(); z++){
    if(coordinates.get(z).y > 249 && coordinates.get(z).y < 549 && coordinates.get(z).x > 449 && coordinates.get(z).x < 749){
        g.setColor(new Color(redList.get(z).intValue(), greenList.get(z).intValue(), blueList.get(z).intValue()));
        g.fillOval(coordinates.get(z).x, coordinates.get(z).y, 7, 7);
    }
 }