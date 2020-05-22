g2d.translate(0, -yOffset);
double width = pageFormat.getImageableWidth();
double scale = width / component.getWidth();
if (scale < 1) {
    AffineTransform oldTransform = g2d.getTransform();
    g2d.scale(scale, scale);
    component.printAll(g2d);
    g2d.setTransform(oldTransform);
} else {
    component.printAll(g2d);
}
g2d.translate(0, +yOffset);