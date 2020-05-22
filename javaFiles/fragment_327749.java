GeneralPath gp = new GeneralPath();
double tstep = (tmax - tmin) / 998;
for (double t=tmin; t += tstep; t<tmax) {
    double x = evaluateX(t);
    double y = evaluateY(t);
    if (t == 0) {
        gp.moveTo(x, y);
    } else {
        gp.lineTo(x, y);
    }
}
g2d.draw(gp);