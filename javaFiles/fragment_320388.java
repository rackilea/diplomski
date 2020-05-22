public class TenDice {

    private static String strJoin(String[] lst, String delimeter) {
        StringBuilder sb = new StringBuilder();

        for (String s : lst) {
            if (s != null) {
                sb.append(s).append(delimeter);
            }
        }

        sb.setLength(sb.length() - delimeter.length());
        return sb.toString();
    }

    public static class HistogramBar {
        private String[] data;
        private int top;
        private int size;

        public HistogramBar(int size) {
            data = new String[size];
        }

        public void add(String s) {
            data[top++] = s;
            size++;
        }

        public String[] getData() {
            return data;
        }

        public int getSize() {
            return size;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of trials: ");
        int trials = scan.nextInt();
        int numberDice = 10;
        int sidesPerDice = 6;

        HistogramBar[] results = getDiceTrialHistogram(numberDice, sidesPerDice, trials);
        System.out.println(results.length);

        for (int i = 0; i < results.length; i++) {
            int sum = i + 10;
            int length = results[i].getSize();
            System.out.printf("%d: %d\n", sum, length);
        }

        System.out.println("\nHistogram");

        for (HistogramBar histBar : results) {
            System.out.printf("|%s\n", strJoin(histBar.getData(), ""));
        }
    }

    private static HistogramBar[] getDiceTrialHistogram(int numberDice, int sidesPerDice, int trials) {
        int totalSum = numberDice * sidesPerDice;
        int size = totalSum - numberDice + 1;

        HistogramBar[] results = new HistogramBar[size];
        for (int i = 0; i < size; i++) {
            results[i] = new HistogramBar(trials);
        }

        Random r = new Random();

        for (int i = 0; i < trials; i++) {
            int total = 0;

            for (int rolls = 0; rolls < numberDice; rolls++) {
                total += r.nextInt(6) + 1;
            }

            HistogramBar totalList = results[total - numberDice + 1];
            totalList.add("*");
        }

        return results;
    }

}