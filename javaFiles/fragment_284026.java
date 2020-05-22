public class HexagonalGrid {
  // Helper class Cell
  public static class Cell {
    public int x;
    public int y;

    public Cell(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }


  // ranges are
  // x -> [-width, width]
  // y -> [-height, height]
  private int width;
  private int height;

  public HexagonalGrid(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public ArrayList<Cell> getNeighbours(Cell target)  {
    ArrayList<Cell> neighbours = new ArrayList<>();

    // These coordinates are predictable, so let's generate them
    // Each immediate 
    for (int x_offset = -1; x_offset <= 1; x_offset++) {
      for (int y_offset = -1; y_offset <= 1; y_offset++) {
        // No offset puts us back at target cell so skip
        if (x_offset == 0 && y_offset == 0) { 
          continue;
        }

        // Generate the cell with the offset
        int x = target.x + x_offset;
        int y = target.y + y_offset;

        // Check validity against bounds
        if (isValidCoordinate(x, y)) {
          // Add valid neighbour
          Cell neighbour = new Cell(x, y);
          neighbours.add(neighbour);
        }
      }
    }

    return neighbours;
  }


  private boolean isValidCoordinate(int x, int y) {
    // Enforcing the ranges specified above
    return -width <= x && x <= width
        && -height <= y && y <= height;
  }
}