public class Partition {
    public static void main(String[] args) {
        System.out.println(GetSequences(180, 1, new HashMap<>()));
    }

    public static int GetSequences(int n, int k, Map<Pair, Integer> data) {
        if (n <= k)
            return 0;

        int result = 1;

        for (int i = k + 1; i < n; i++) {
            Pair p = new Pair(n - i, i);
            if (data.containsKey(p)) {
                result += data.get(p);
            } else {
                int res = GetSequences(n - i, i, data);
                data.put(p, res);
                result += res;
            }
        }
        return result;
    }

    static class Pair {
        int n;
        int k;

        Pair(int n, int k) {
            this.n = n;
            this.k = k;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + k;
            result = prime * result + n;
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
            Pair other = (Pair) obj;
            if (k != other.k)
                return false;
            if (n != other.n)
                return false;
            return true;
        }

    }