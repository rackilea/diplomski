double x, y, xPerF, yPerF; //Values for drawing
double x1, x2, y1, y2; //Values for the targets
x1 = getCenterX();
x2 = Canvas.target[shotTarget].getCenterX();
y1 = getCenterY();
y2 = Canvas.target[shotTarget].getCenterY();
xPerF = (Math.max(x1, x2) - Math.min(x1, x2))/animationSpeed;
yPerF = (Math.max(y1, y2) - Math.min(y1, y2))/animationSpeed;
if(x1>x2) x = x1 - xPerF * animationFrame;
else if(x1<x2) x = x1 + xPerF * animationFrame;
else x = x1;
if(y1>y2) y = y1 - yPerF * animationFrame;
else if(y1<y2) y = y1 + yPerF * animationFrame;
else y = y1;
g.fillOval((int) x - 15, (int) y - 15, 30, 30);