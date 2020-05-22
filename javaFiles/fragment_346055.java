public class Thingy {

    public static void main(String[] args) {
        printAll(0, 0, Arrays.asList(1L, 2L, 3L, 4L), "TEST1> ");
        printAll(0, 0, Arrays.asList(5L, 6L, 3L, 8L, 9L), "TEST2> ");
    }

    private static void printAll(int i, long accumulator, List<Long> source, String output) {
        if(i >= source.size()) {
            System.out.println(output + " = " + accumulator);
        } else {
            long n = source.get(i);
            printAll(i + 1, accumulator + n, source, output + " + " + n);
            printAll(i + 1, accumulator - n, source, output + " - " + n);
        }
    }
}