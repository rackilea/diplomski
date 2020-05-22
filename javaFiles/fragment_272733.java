public class Sets {
    private static final int NOT_ENOUGH_MATCHES = -1;
    private static final String[] arrayOne = { "1", "2", "4", "9" };
    private static final String[] arrayTwo = { "2", "3", "5", "7", "9" };
    private static final Set<String> setOne = new HashSet<>();
    private static final Set<String> setTwo = new HashSet<>();

    public static void main(String[] ignoredArguments) {
        setOne.addAll(Arrays.asList(arrayOne));
        setTwo.addAll(Arrays.asList(arrayTwo));
        boolean isFirstSmaller = setOne.size() < setTwo.size();
        System.out.println("Number shared: " + (isFirstSmaller ?
                numberShared(setOne, setTwo) : numberShared(setTwo, setOne)));
    }

    private static long numberShared(Set<String> smallerSet, Set<String> largerSet) {
        SimpleBag bag = new SimpleBag(3, 0.5d, largerSet, smallerSet.size());
        try {
            smallerSet.forEach(eachItem -> bag.add(eachItem));
            return bag.duplicateCount;
        } catch (IllegalStateException exception) {
            return NOT_ENOUGH_MATCHES;
        }
    }

    public static class SimpleBag {
        private Map<String, Boolean> items;
        private int threshold;
        private double fraction;
        protected int duplicateCount = 0;
        private int smallerSize;
        private int numberLeft;

        public SimpleBag(int aThreshold, double aFraction, Set<String> someStrings,
                int otherSetSize) {
            threshold = aThreshold;
            fraction = aFraction;
            items = new HashMap<>();
            someStrings.forEach(eachString -> items.put(eachString, false));
            smallerSize = otherSetSize;
            numberLeft = otherSetSize;
        }

        public void add(String aString) {
            Boolean value = items.get(aString);
            boolean alreadyExists = value != null;
            if (alreadyExists) {
                duplicateCount++;
            }
            items.put(aString, alreadyExists);
            numberLeft--;
            if (cannotMeetThreshold()) {
                throw new IllegalStateException("Can't meet threshold; stopping at "
                        + duplicateCount + " duplicates");
            }
        }

        public boolean cannotMeetThreshold() {
            return duplicateCount < threshold
                    && (duplicateCount + numberLeft < fraction * smallerSize);
        }
    }
}