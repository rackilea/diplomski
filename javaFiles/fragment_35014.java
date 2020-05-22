class Point { 
    protected final int x, y;

    public Point(int x, int y) { 
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() { 
        return "["+x+", "+y+"]";
    }
}

class ColorPoint extends Point { 
    private final String color;

    public ColorPoint(int x,int y, String color) { 
        super(x, y);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ":" + color;
    }
}