public class Ranges {

    // A class that models a range of integers
    public static class Range {
        private int low;
        private int high;

        public Range(int low, int high) {
            this.low = low;
            this.high = high;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }

        @Override
        public String toString() {
            return (low == high) ? String.valueOf(low) : String.format("%d-%d", low, high);
        }
    }

    public static void main(String[] args) {
        String input = "2,3,6,7,8,10,12,14,15,16";

        // Turn input string into a sorted list of integers
        List<Integer> inputNumbers = new ArrayList<Integer>();
        for (String num : input.split(",")) {
            inputNumbers.add(Integer.parseInt(num));
        }
        Collections.sort(inputNumbers);

        // Flatten list of integers into a (shorter) list of Ranges
        Range thisRange = null; // the current range being built
        List<Range> ranges = new ArrayList<Range>();
        for (Integer number : inputNumbers) {
            if (thisRange != null && number <= thisRange.getHigh() + 1) {
                // if we are already building a range (not null) && this new number is 
                // the old high end of the range + 1, change the high number.
                thisRange.setHigh(number);
            } else {
                // create a new range and add it to the list being built
                thisRange = new Range(number, number);
                ranges.add(thisRange);
            }
        }

        // Join List<String> into a single String
        String result = StringUtils.collectionToCommaDelimitedString(ranges);
        System.out.println("result = " + result);
    }
}