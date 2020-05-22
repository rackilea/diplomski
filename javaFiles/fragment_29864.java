int offs = this.thickness;
int size = offs + offs;
if (this.roundedCorners) {
    float arc = .2f * offs;
    outer = new RoundRectangle2D.Float(x, y, width, height, offs, offs);
    inner = new RoundRectangle2D.Float(x + offs, y + offs, width - size, height - size, arc, arc);
}
else {
    outer = new Rectangle2D.Float(x, y, width, height);
    inner = new Rectangle2D.Float(x + offs, y + offs, width - size, height - size);
}
Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD);
path.append(outer, false);
path.append(inner, false);
g2d.fill(path);