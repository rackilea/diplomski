int cellHeight = d.height/10;
int cellWidth = d.width/5;

int xOffset = cellWidth/6;
int yOffset = cellHeight/6;

int[] xPoints = {cellWidth/2, xOffset, cellWidth - xOffset}; 
int[] yPoints = {yOffset, cellHeight - yOffset, cellHeight - yOffset};

Polygon triangle = new Polygon(xPoints, yPoints, xPoints.length);