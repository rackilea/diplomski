Graphics2D g2 = (Graphics2D) g;
int w = // real width of canvas
int h = // real height of canvas
// Translate used to make sure scale is centered
g2.translate(w/2, h/2);
g2.scale(scale, scale);
g2.translate(-w/2, -h/2);