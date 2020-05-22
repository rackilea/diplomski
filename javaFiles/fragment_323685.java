class StickFigure {

    private Area stickFigure;
    private Color color;

    StickFigure(Color color, int x) {
        this.color = color;
        stickFigure = new Area(new Ellipse2D.Double(x, 0, 100, 100));
        stickFigure.add(new Area(new Rectangle(x+25, 100, 50, 110)));
    }

    public Area getStickFigure() {
        return stickFigure;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fill(stickFigure);
    }
}