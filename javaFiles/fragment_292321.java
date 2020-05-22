public class Main {
    public static void main(String[] args) {
        startRecursion(5);
    }

    private static void startRecursion(int number) {
        String aligner = "";
        for (int i = 0; i < number - 1; i++) {
            aligner += " ";
        }
        recursion(String.valueOf(number), number, number, aligner);
    }

    private static void recursion(String value, int startNumber, int lastNumber, String aligner) {
        if (lastNumber < 1) {
            return;
        }

        if (lastNumber != startNumber) {
            value = lastNumber + value + lastNumber;
        }

        System.out.println(aligner + value);

        if (!aligner.isEmpty()) {
            aligner = aligner.substring(0, aligner.length() - 1);
        }

        recursion(value, startNumber, lastNumber - 1, aligner);
    }
}