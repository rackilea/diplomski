public class Main {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>(Arrays.asList("N1", "N2", "N3", "N5", "N7", "N14"));

        Stream<Integer> st = arr.stream().map(p -> Integer.parseInt(p.substring(1))).sorted();
        Holder<Integer> holder = st.collect(() -> new Holder<Integer>(), 
                (h, i) -> {
                    Integer last = h.getProcessed().isEmpty() ? null : h.getProcessed().get(h.getProcessed().size() - 1);
                    if (last != null) {
                        while (i - last > 1) {
                            h.getMissing().add(++last);
                        }
                    }
                    h.getProcessed().add(i);
                }, 
                (h, h2) -> {});
        holder.getMissing().forEach(System.out::println);
    }

    private static class Holder<T> {
        private ArrayList<T> processed;
        private ArrayList<T> missing;

        public Holder() {
            this.processed = new ArrayList<>();
            this.missing = new ArrayList<>();
        }

        public ArrayList<T> getProcessed() {
            return this.processed;
        }

        public ArrayList<T> getMissing() {
            return this.missing;
        }
    }
}