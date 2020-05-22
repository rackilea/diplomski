class A {
    static class SameHash {
        final int n;

        SameHash(int n) {
            this.n = n;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public String toString() {
            return "SameHash{" +
                    "n=" + n +
                    '}';
        }
    }

    public static void main(String[] args) {
        HashSet<SameHash> set = new HashSet<>();
        for (int i = 1; i <= 4; i++)
            set.add(new SameHash(i));
        System.out.println(set);
    }
}