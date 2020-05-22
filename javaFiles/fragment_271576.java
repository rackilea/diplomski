//TRANSLATE TO ORIGIN
double x1 = p1.getX() - center_triangle.x;
double y1 = p1.getY() - center_triangle.y;

//APPLY ROTATION
x1 = x1 * Math.cos(angle) - y1 * Math.sin(angle));
y1 = x1 * Math.sin(angle) + y1 * Math.cos(angle));

//TRANSLATE BACK
p1.setLocation(x1 + center.x, y1 + center.y);