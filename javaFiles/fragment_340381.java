public class ReverseLookup {
    static class Pair<L,R> {
        private L l;
        private R r;
        public Pair(L l, R r) {
            this.l = l;
            this.r = r;
        }
        public L getL() {return l;}
        public R getR() {return r;}
        public void setL(L l){this.l = l;}
        public void setR(R r){this.r = r;}

        public static <L, R> Pair<L, R> right(List<Pair<L, R>> pairs, R rVal) {
            for (Pair<L, R> pair : pairs) {
                if (rVal != null && rVal.equals(pair.getR()))
                    return pair;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        String lookFor = "bob";
        Map<String, List<Pair <Integer, String>>> listOfPairs = new TreeMap<>();
        listOfPairs.put(
            "key1", Arrays.asList(new Pair("2", "carol"), new Pair(4, "david"))
            );
        listOfPairs.put(
        "key2", Arrays.asList(new Pair("0", "alice"), new Pair(1, "bob"))
        );
        for (Map.Entry<String, List<Pair<Integer, String>>> entry : listOfPairs.entrySet()) {
            // entry is a mapping from string -> list of pairs Integer, String
            List<Pair<Integer, String>> pairs = entry.getValue();
            if (Pair.right(pairs, lookFor) != null) {
                System.out.println(entry.getKey());
            }
        }
    }
}