import java.util.*;

public class Main {
    public static class PermutationComparator implements Comparator<String> {
        private final Map<Character, Integer> order;

        public PermutationComparator(String permutation) {
            this.order = new HashMap<Character, Integer>();
            for (int i = 0; i < permutation.length(); i++) {
                order.put(permutation.charAt(i), i);
            }
        }

        private int getOrder(char c) {
            Integer value = order.get(c);
            if (value == null) return -1;
            return value;
        }

        @Override
        public int compare(String o1, String o2) {
            for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                int compare = Integer.compare(getOrder(o1.charAt(i)), getOrder(o2.charAt(i)));
                if (compare != 0) return compare;
            }
            return Integer.compare(o1.length(), o2.length());
        }
    }

    public static void main(String... args) {
        String[] strings = {"ant", "bear", "cat", "zoo", "animal"};
        Arrays.sort(strings, new PermutationComparator("zyxwvutsrqponmlkjihgfedcba"));
        System.out.println(Arrays.toString(strings));
    }
}