int dx, dy, dw, dh;
dx = 2*idx;
dy = 2*idx;
dw = 2*dx; // note this is 4*idx not 5*idx like you have currently
dh = 2*dy;
g.fillOval(width+dx, height+dy, widthOval-dw, heightOval-dh);