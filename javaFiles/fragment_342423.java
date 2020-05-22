double angle = ang * Math.PI / 180;
double sin = Math.sin(angle);
double cos = Math.cos(angle);       

double a = (centerX + ray) - x0;
double b = centerY - y0;
int xx = (int) (a * cos - b * -sin + x0);
int yy = (int) (a * -sin + b * cos + y0);

ang++;