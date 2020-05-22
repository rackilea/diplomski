public class Ranges {

    public static void main(String[] args) {
        int batchTotal = 605;
        int batchInterval = 100;

        System.out.println(generateBatches(batchTotal, batchInterval).toString());

        batchTotal = 605;
        batchInterval = 5;

        System.out.println(generateBatches(batchTotal, batchInterval).toString());
    }

    public static List<String> generateBatches(int batchTotal, int batchInterval) {
        List<String> ranges = new ArrayList<String>();
        int n = batchTotal;
        int rangeStart = 0;
        while (n > 0) {
            ranges.add(rangeStart + "-" + ((rangeStart + batchInterval) > batchTotal ? batchTotal : rangeStart + batchInterval));
            rangeStart += batchInterval;
            n -= batchInterval;
        }
        return ranges;
    }

}