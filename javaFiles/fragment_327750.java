GeneralPath gp = new GeneralPath();
final double scale = 3.0;
double tstep = (tmax - tmin) / 998;
for (double t=tmin; t += tstep; t<tmax) {
    double x = scale * evaluateX(t);
    double y = scale * evaluateY(t);
    if (t == 0) {
        gp.moveTo(x, y);
    } else {
        gp.lineTo(x, y);
    }
}
g2d.draw(gp);