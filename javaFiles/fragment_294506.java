Shape originalClip = myBuffer.getClip();
myBuffer.clipRect(0, 40, 1000, 1000 - 40);

double x = pm.getX();
double y = pm.getY();
double angle = Math.atan2(pm.getdy(), pm.getdx());
double dx = PACMAN_RADIUS * Math.sin(angle);
double dy = PACMAN_RADIUS * Math.cos(angle);

double x1 = x - dx;
double x2 = x + dx;
double y1 = y - dy;
double y2 = y + dy;

myBuffer.setColor(Color.BLUE);

myBuffer.drawLine((int) (x1 - 5000 * dy),
                  (int) (y1 + 5000 * dx),
                  (int) (x1 + 5000 * dy),
                  (int) (y1 - 5000 * dx));

myBuffer.drawLine((int) (x2 - 5000 * dy),
                  (int) (y2 + 5000 * dx),
                  (int) (x2 + 5000 * dy),
                  (int) (y2 - 5000 * dx));

myBuffer.setClip(originalClip);