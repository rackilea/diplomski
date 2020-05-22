// I agree with Matt that color (or type) should probably be an enum, 
// or at least a class.  int isn't very descriptive
public enum CellType { GRAY, RED, ORANGE }

public class Cell{
....
    public final CellType type;

    /**
     * Recursively find all adjacent cells that have the same type as this one.
     */
    public List<Cell> getTouchingSimilarCells() {
        List<Cell> result = new ArrayList<Cell>();
        result.add(this);
        for (Cell c : getAdjecentCells()) {
            if (c != null && c.type == this.type) {
                result.addAll(c.getTouchingSimilarCells());
            }
        }
        return result;
    }

    /**
     * Get the 4 adjacent cells (above, below, left and right).<br/>
     * NOTE: a cell may be null in the list if it does not exist.
     */
    public List<Cell> getAdjecentCells() {
        List<Cell> result = new ArrayList<Cell>();
        result.add(cellBlock(this.getX() + 1, this.getY()));
        result.add(cellBlock(this.getX() - 1, this.getY()));
        result.add(cellBlock(this.getX(), this.getY() + 1));
        result.add(cellBlock(this.getX(), this.getY() - 1));
        return result;
    }
}