Graphics2D g2d = (Graphics2D) g.create();
int yPos = (getHeight() - size) / 2;
// Transform the offset
g2d.transform(AffineTransform.getTranslateInstance(xPos, yPos));

Graphics2D earthG = (Graphics2D) g2d.create();
// Rotate around the 0x0 point, this becomes the center point
earthG.transform(AffineTransform.getRotateInstance(Math.toRadians(angle)));
// Draw the "earth" around the center point
earthG.drawRect(-(size / 2), -(size / 2), size, size);
earthG.dispose();

// Removes the last transformation
Graphics2D moonG = (Graphics2D) g2d.create();            
// Calclate the point on the circle - based on the outterRadius or
// distance from the center point of the earth
Point poc = pointOnCircle();
int moonSize = size / 2;
// This is only a visial guide used to show the position of the earth
//moonG.drawOval(-outterRadius, -outterRadius, outterRadius * 2, outterRadius * 2);
moonG.fillOval(poc.x - (moonSize / 2), poc.y - (moonSize / 2), moonSize, moonSize);
moonG.dispose();

g2d.dispose();