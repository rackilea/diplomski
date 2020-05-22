double lengthX = r * Math.cos(angle);
double lengthY = r * Math.sin(angle);

xStart = (point1.x) + offsetFraction * lengthX;
yStart = (point1.y) + offsetFraction * lengthY;
xEnd = (point1.x) + lengthX;
yEnd = (point1.y) + lengthY;

//Draw paths
path.reset();
path.moveTo((float) xStart, (float) yStart);
path.lineTo((float) xEnd, (float) yEnd);
canvas.drawPath(path, paint);