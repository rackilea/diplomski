public class Staircase {

    private static HashMap<Staircase, Integer> cache;

    public static void main(String[] args) {
        cache = new HashMap<>();
        int bricks = 6;
        Staircase toBuild = new Staircase(1, bricks);
        System.out.println(toBuild.waysToBuild() - 1);
    }

    public final int height;
    public final int bricksLeft;

    public Staircase(int height, int bricksLeft) {
        this.height = height;
        this.bricksLeft = bricksLeft;
    }

    public int waysToBuild() {
        if (cache.containsKey(this)) {
            return cache.get(this);
        }

        int toReturn;
        if (bricksLeft == 0) {
            toReturn = 1;
        } else if (bricksLeft < height) {
            toReturn = 0;
        } else {
            Staircase component1 = new Staircase(height + 1, bricksLeft - height);
            Staircase component2 = new Staircase(height + 1, bricksLeft);
            toReturn = component1.waysToBuild() + component2.waysToBuild();
        }

        cache.put(this, toReturn);
        return toReturn;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Staircase) {
            if (height != ((Staircase) other).height) {
                return false;
            }
            if (bricksLeft != ((Staircase) other).bricksLeft) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.height;
        hash = 73 * hash + this.bricksLeft;
        return hash;
    }
}