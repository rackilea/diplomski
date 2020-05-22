import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RectangleTest {
  RangeList xRanges = new RangeList();
  RangeList yRanges = new RangeList();


  public static void main(String[] args) {
    RectangleTest rectangleTest = new RectangleTest();
    rectangleTest.test();
  }

  private void test() {
    Rectangle[] rectangles = new Rectangle[]{
        new Rectangle(2,100,4,102),
        new Rectangle(2,102,4,200),
    };
    add(rectangles[0]);
    add(rectangles[1]);
    testit(0,0);
    testit(3,101);
    testit(4,101);
    testit(4,102);
    delete(rectangles[0]);
    testit(3,101);
    testit(4,101);
    testit(4,102);
  }

  private void testit(int x, int y){
    System.out.println("("+x+","+y+") is in "+getRectangles(x,y));
  }

  void add(Rectangle rectangle) {
    System.out.println("Adding: "+rectangle);
    xRanges.addRectangle(rectangle.x1, rectangle.x2, rectangle);
    yRanges.addRectangle(rectangle.y1, rectangle.y2, rectangle);
  }

  void delete(Rectangle rectangle){
    System.out.println("Deleting: "+rectangle);
    xRanges.deleteRectangle(rectangle.x1, rectangle.x2, rectangle);
    yRanges.deleteRectangle(rectangle.y1, rectangle.y2, rectangle);
  }

  Set<Rectangle> getRectangles(int x, int y){
    Set<Rectangle> result = xRanges.lookup(x);
    result.retainAll(yRanges.lookup(y));
    return result;
  }
}

/* A Range represents a range of locations in one dimension, and
 * and associated set of rectangles.
 */
class Range {
  int start;
  Set<Rectangle> rectangles;

  Range(int start) {
    this(start, new HashSet<Rectangle>());
  }

  Range(int start, Set<Rectangle> rectangles) {
    this.start = start;
    this.rectangles = rectangles;
  }

  void add(Rectangle rectangle) {
    rectangles.add(rectangle);
  }

  void remove(Rectangle rectangle) {
    rectangles.remove(rectangle);
  }
}

/* A RangeList represents all ranges in one dimension.*/
class RangeList {
  List<Range> ranges = new ArrayList<Range>();
  static final int endAll = Integer.MAX_VALUE;

  RangeList() {
    ranges.add(new Range(0));
  }

  void addRectangle(int start, int end, Rectangle rectangle) {
    int startIndex = getIndex(start);
    Range startRange = ranges.get(startIndex);
    if (start > startRange.start) {
      // Need to split the start range
      startIndex++;
      ranges.add(startIndex, new Range(start, new HashSet<Rectangle>(
          startRange.rectangles)));
    }
    int endIndex = getIndex(end);
    Range endRange = ranges.get(endIndex);
    if (end > endRange.start) {
      // Need to split the end range
      ranges.add(endIndex + 1, new Range(end, new HashSet<Rectangle>(
          endRange.rectangles)));
    }
    // Add the rectangle to its ranges
    for (int i = startIndex; i <= endIndex; i++) {
      ranges.get(i).rectangles.add(rectangle);
    }

  }

  void deleteRectangle(int start, int end, Rectangle rectangle) {
    int startIndex = getIndex(start);
    int endIndex = getIndex(end);
    // Remove the rectangle from each range it is in
    for (int i = startIndex; i <= endIndex; i++) {
      ranges.get(i).rectangles.remove(rectangle);
    }
    // Merge ranges that now have equal rectangle sets
    for (int i = endIndex; i >= Math.max(startIndex, 1); i--) {
      if (ranges.get(i).rectangles.equals(ranges.get(i - 1).rectangles)) {
        ranges.remove(i);
      }
    }
  }

  Set<Rectangle> lookup(int location) {
    int index = getIndex(location);
    Range range = ranges.get(index);
    Set<Rectangle> result = new HashSet<Rectangle>(range.rectangles);
    if (location == range.start && index > 0) {
      // On the boundary, include ranges ending at location
      result.addAll(ranges.get(index - 1).rectangles);
    }
    return result;
  }

  /* Find the index of the range containing the location. For this
   * purpose only, ranges are treated as being closed on the left, open
   * on the right, so that every point is in exactly one range.
   */
  int getIndex(int location) {
    int rangeCount = ranges.size();
    if (rangeCount == 1) {
      return 0;
    }
    return getIndex(location, 0, rangeCount - 1);
  }

  /* Get the index of the range containing the location, as above, but
   * assuming the index is in [start,end]. Recursive binary search.
   */
  private int getIndex(int location, int start, int end) {
    if (start == end) {
      return start;
    }
    int mid = (start + end + 1) >>> 1;
    if (location < ranges.get(mid).start) {
      return getIndex(location, start, mid - 1);
    } else {
      return getIndex(location, mid, end);
    }
  }
}

class Rectangle {
  int x1;
  int y1;
  int x2;
  int y2;

  public Rectangle(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + x1;
    result = prime * result + x2;
    result = prime * result + y1;
    result = prime * result + y2;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Rectangle other = (Rectangle) obj;
    if (x1 != other.x1)
      return false;
    if (x2 != other.x2)
      return false;
    if (y1 != other.y1)
      return false;
    if (y2 != other.y2)
      return false;
    return true;
  }

  public String toString() {
    return "[" + x1 + "," + y1 + "][" + x2 + "," + y2 + "]";
  }
}