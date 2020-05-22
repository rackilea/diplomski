GeneralPath gp = new GeneralPath();

gp.moveTo(0, 0);
// create the Archimmedian spiral in one direction
for (double a = 0d; a < Math.PI * 2 * rotations; a += step) {
    Point2D p = getPoint(a, 1);
    gp.lineTo(p.getX(), p.getY());
}

gp.moveTo(0, 0);
// now reverse the direction
for (double a = 0d; a < Math.PI * 2 * rotations; a += step) {
    Point2D p = getPoint(a, -1);
    gp.lineTo(p.getX(), p.getY());
}