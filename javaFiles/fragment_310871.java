public class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair otherPair = (Pair) obj;
        if (this.getX() != otherPair.getX() || this.getY() != otherPair.getY()) {
            return false;
        }

        return true;
    }

    // getters and setters
}

public class PairTest {
    public static void main(String[] args) {
        Random randomGenerator = new Random();

        int[] a={1,2,3,4,5};
        int[] b={6,7};

        Set<Pair> pairs = new HashSet<Pair>();

        do {
            int xRand = randomGenerator.nextInt(a.length);
            int yRand = randomGenerator.nextInt(b.length);

            Pair p;
            if (xRand % 2 == 0) {
                Pair p = new Pair(a[xRand], b[yRand]);
            }
            else {
                Pair p = new Pair(b[yRand], a[xRand]);
            }
            pairs.add(p);
            if (pairs.size() == 10) break;
        } while (true);
    }
}