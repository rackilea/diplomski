public class XYCoord {

    private int x;
    private int y;

    public XYCoord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof XYCoord))
            return false;

        XYCoord other = (XYCoord) obj;
        if (x == other.x && y == other.y)
            return true;

        return false;
    }

}