Graphics2D graphics = /* your graphics object */;
double[] x = /* x coordinates of polyline */;
double[] y = /* y coordinates of polyline */;

Path2D polyline = new Path2D.Double();
polyline.moveTo(x[0], y[0]);
for (int i = 1; i < x.length; i++) {
    polyline.lineTo(x[i], y[i]);
}

graphics.draw(polyline);