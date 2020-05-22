public class Queen {
    int i, j;

    public Queen(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public boolean checkKnight(Queen queen) { // if any queen meets another
                                                // queen at 2 and 1 offset, we
                                                // eliminate it.
        return (Math.abs(i - queen.i) == 2 && Math.abs(j - queen.j) == 1)
                || (Math.abs(i - queen.i) == 1 && Math.abs(j - queen.j) == 2);
    }
}