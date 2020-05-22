import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class KnightMove {

    @SuppressWarnings("serial")
    private static final class KnightMoveSolvedException extends RuntimeException {

        private final byte[][] solution;

        private KnightMoveSolvedException(final byte[][] solution) {
            this.solution = solution;
        }
    }

    private static final int      SIZE_X       = 8;
    private static final int      SIZE_Y       = 8;
    private static final int      SIZE_X_Y     = SIZE_X * SIZE_Y; // Max 127! (=0x7F)

    private static final int [][] KNIGHT_MOVES = new int[8][];
    /**/    static {     
        final AtomicInteger moveIndex = new AtomicInteger();

        IntStream.of(2, -2).forEach(deltaX ->
        IntStream.of(1, -1).forEach(deltaY -> {
            /*
             * Mirror the 4 combinations above to get all 8 possible Knight moves...
             */
            KNIGHT_MOVES[moveIndex.getAndIncrement()] = new int[] {deltaX, deltaY};
            KNIGHT_MOVES[moveIndex.getAndIncrement()] = new int[] {deltaY, deltaX};  
        }));
    }

    private static void nextMoveToXY(int moveCount, final int x, final int y, final byte[][] board) {
        moveCount++;

        board[x][y] = (byte) moveCount;

        if (moveCount >= SIZE_X_Y) {

            System.out.println("Solved!.....: count=" + moveCount);

            for (    final byte[] column : board ) {
                for (final byte   square : column) {
                    System.out.print(square + "\t");
                }
                System.out.println();
            }
            return;  // (Back up & keep looking for next solution)
            /*
             * If 1 solution is enough, just throw the Exception...
             */
//          throw new KnightMoveSolvedException(board);
        }

        for (final int[] knightMove : KNIGHT_MOVES) {

            final int newX = x + knightMove[0];  if (newX < 0 || newX >= SIZE_X) {continue;}
            final int newY = y + knightMove[1];  if (newY < 0 || newY >= SIZE_Y) {continue;}

            if (board[newX][newY] == 0) {
                /*
                 * Target Square is vacant, so try this move recursively...
                 */
                nextMoveToXY(moveCount, newX, newY, deepPrimitive2DArrayClone(board));
            }
        }
    }

    /**
     * {@link Object#clone()} can create a Deep Clone of a 1D array of Primitives
     * but will <b>not</b> deliver the desired result with 2D,
     * so we have to wrap the rest by hand...
     */
    private static byte[][] deepPrimitive2DArrayClone(final byte[][] source) {

        final byte[][] clone = new byte[source.length][];
        /**/  int      cix   = 0;

        for (final byte[]  col : source) {
            clone[cix++] = col.clone();
        }
        return clone;
    }

    public static void main(final String[] args) throws Exception {

        IntStream.range(0, SIZE_X).forEach(x ->
        IntStream.range(0, SIZE_Y).forEach(y -> {
            try {
                System.out.println("Solve starting at X/Y.: " + x +"/" + y);

                nextMoveToXY(0, x, y, new byte[SIZE_X][SIZE_Y]);
            }
            catch (final KnightMoveSolvedException e) {
                System.out.println(e.solution);
            }
        }));
    }
}