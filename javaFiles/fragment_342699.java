float rot = 2.0; // angle in radians
Point2D.Float p1 = new Point2D.Float(10.0,10.0);
Point2D.Float p1Rotated = new Point2D.Float(0,0);
float dx = Math.cos(rot);
float dy = Math.sin(rot);
p1Rotated.x = p1.x * dx + p1.y * -dy;
p1Rotated.y = p1.x * dy + p1.y * dx;