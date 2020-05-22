import java.util.ArrayDeque;
import java.awt.Point;  // This is probably superfluous, an int[] with two elements would do fine here too

public class Test
{
    private static int[][] a = new int[][] {
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0},
        {0, 1, 1 ,0, 1, 0},
        {1, 0, 0, 0, 0, 1},
        {0, 1, 0, 1, 0, 1},
        {0, 0, 1, 0, 1, 0}
    };

    /*
     * Applies flood fills all elements accessible from array[row][col] with
     * value. If the element at (row, col) is already value, this method does
     * nothing.
     */
    private static void floodFill(int[][] array, int row, int col, int value)
    {
        int oldValue = array[row][col];
        if(oldValue == value)
            return;
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(col, row));
        while(queue.size() > 0) {
            // Technically, removeLast would be more efficient, especially
            // since the order does not matter, but this is just an example
            Point point = queue.pop();
            int r = point.y;
            int c = point.x;
            array[r][c] = value;

            if(r > 0 && array[r - 1].length > c && array[r - 1][c] == oldValue)
                queue.add(new Point(c, r - 1));
            if(r < array.length - 1 && array[r + 1].length > c && array[r + 1][c] == oldValue)
                queue.add(new Point(c, r + 1));
            if(c > 0 && array[r][c - 1] == oldValue)
                queue.add(new Point(c - 1, r));
            if(c < array[r].length - 1 && array[r][c + 1] == oldValue)
                queue.add(new Point(c + 1, r));
        }
    }

    /*
     * Walks around the edges of the array and floods everthing connected to
     * them with ones. This relies on floodFill exiting early for areas that
     * were already filled.
     */
    private static void fillEdges(int[][] array)
    {
        // top row
        for(int col = 0; col < array[0].length; col++)
            floodFill(array, 0, col, 1);
        // left column
        for(int row = 0; row < array.length; row++)
            floodFill(array, row, 0, 1);
        // bottom row
        for(int col = 0; col < array[array.length - 1].length; col++)
            floodFill(array, array.length - 1, col, 1);
        // all trailing row segments (allows for ragged arrays)
        for(int row = 1; row < array.length - 1; row++) {
            int lengthToFill = array[row].length - Math.min(array[row - 1].length, array[row + 1].length);
            lengthToFill = (lengthToFill < 0) ? 1 : lengthToFill + 1;
            for(int col = array[row].length - lengthToFill; col < array[row].length; col++)
                floodFill(array, row, col, 1);
        }
    }

    public static void main(String[] args)
    {
        fillEdges(a);
        for(int row = 0; row < a.length; row++) {
            for(int col = 0; col < a[row].length; col++) {
                if(a[row][col] == 0)
                    System.out.println("[" + row + "][" + col + "]");
            }
        }
    }
}