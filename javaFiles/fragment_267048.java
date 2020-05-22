public class Main {
    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(4, 5, 8, 4, 5, 1, 2, 10, 1, 0, 12);
        final int pivot = 3;

        Collections.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int d1 = Math.abs(a - pivot);
                int d2 = Math.abs(b - pivot);
                return Integer.compare(d1, d2);
            }
        });

        System.out.println(arr);
    }
}