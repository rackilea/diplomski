import java.util.Arrays;
public class Exercise {
    private final double[] array;
    public Exercise(double first, double second) {
        this.array = new double[]{first, second};
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof Exercise)) {
            return false;
        }
        Exercise other = (Exercise)obj;
        return Arrays.equals(this.array, other.array);
    }

    public int hashCode() {
        return Arrays.hashCode(array);
    }
}