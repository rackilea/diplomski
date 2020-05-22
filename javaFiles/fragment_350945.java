public class Coords implements Comparable<Coords> {
    public int x;
    public int z;

    public Coords(int x, int z) {
        this.x = x;
        this.z = z;
    }

    @Override
    public int compareTo(Coords o) {
        if (this.x == o.x) {
            if (this.z == o.z) {
                return 0;
            }
            return this.z < o.z ? -1 : 1;               
        }
        return this.x < o.x ? -1 : 1;
    }

    @Override
    public String toString() {
        return String.format("{%d, %d}", x, z);
    }
}