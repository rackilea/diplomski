class Pair {
    private int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override public int hashCode() {
        int result = 1;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

    @Override public boolean equals(Object obj) {
        if (this == obj)              return true;
        if (!(obj instanceof Pair))   return false;
        Pair tmp = (Pair) obj;
        return (tmp.x == x && tmp.y == y) || (tmp.x == y && tmp.y == x);
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class Testt {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList( 1, 2, 3 );
        List<Integer> l2 = Arrays.asList( 2, 3, 4 );

        Set<Pair> set = new HashSet<Pair>();
        for (int i : l1)
            for (int j : l2)
                set.add(new Pair(i, j));

        System.out.println(set);
    }
}