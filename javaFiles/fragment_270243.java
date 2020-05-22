public Dragger(IFigure figure)
{
    figure.addMouseMotionListener(this);
    figure.addMouseListener(this);

    Rectangle bounds = figure.getBounds();

    last = new Point(bounds.x, bounds.y);
}