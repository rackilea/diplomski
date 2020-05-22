abstract class OpalDraw {
    protected int x1, y1, x2, y2;
    protected OpalDraw(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    abstract public void draw(Graphics g);
}

class OpalOval {
    public OpalOval(int x1, int y1, int x2, int y2) { super(x1,y1,x2,y1); }
    public void draw(Graphics g) {
        g.drawOval(x1,y1,x2,y1);
    }
}

class OpalRect {
    public OpalRect(int x1, int y1, int x2, int y2) { super(x1,y1,x2,y1); }
    public void draw(Graphics g) {
        g.drawRect(x1,y1,x2,y1);
    }
}