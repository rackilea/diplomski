public class ForkJoinSort {

    private static final int LIST_SIZE = 10000;

    private static final int SORT_THRESHOLD = 10; //the minimal length of the list to use standard java sort rather than mergesort

    private static ForkJoinPool forkJoinPool = new ForkJoinPool();

    public static class MergeSortTask extends RecursiveTask<List<Integer>> {

        private final List<Integer> victim;

        public MergeSortTask(List<Integer> victim) {
            this.victim = victim;
        }

        @Override
        protected List<Integer> compute() {
            if (victim.size() < SORT_THRESHOLD) {
                Collections.sort(victim);
                return victim;
            }

            //sorting left and right parts of the list separately in separate threads
            MergeSortTask leftTask = new MergeSortTask(victim.subList(0, victim.size() / 2));
            MergeSortTask rightTask = new MergeSortTask(victim.subList(victim.size() / 2, victim.size()));
            forkJoinPool.submit(leftTask);
            forkJoinPool.submit(rightTask);

            //do merge
            return merge(leftTask.join(), rightTask.join());
        }

        public List<Integer> merge(List<Integer> left, List<Integer> right) {
            List<Integer> result = new ArrayList<Integer>(left.size() + right.size());

            Iterator<Integer> leftIterator = left.iterator();
            Iterator<Integer> rightIterator = right.iterator();

            Integer fromLeft = null;
            Integer fromRight = null;

            while (leftIterator.hasNext() || rightIterator.hasNext()) {
                //if current value taken from the iterator is null - take new one if possible, otherwise do nothing
                fromLeft = fromLeft == null ? leftIterator.hasNext() ? leftIterator.next() : null : fromLeft;
                fromRight = fromRight == null ? rightIterator.hasNext() ? rightIterator.next() : null : fromRight;

                if (fromLeft != null && (fromRight == null || fromLeft <= fromRight)) {
                    result.add(fromLeft);
                    fromLeft = null; //this is done to indicate that value from left iterator already passed to result list
                } else if (fromRight != null && (fromLeft == null || fromRight <= fromLeft)) {
                    result.add(fromRight);
                    fromRight = null;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        SecureRandom random = new SecureRandom();

        //generate array of random numbers
        List<Integer> victim = new ArrayList<Integer>(LIST_SIZE);
        for (int i = 0; i < LIST_SIZE; ++i) {
            victim.add(random.nextInt());
        }

        //do some benchmarking as long as we're here
        long timeMark = System.currentTimeMillis();
        MergeSortTask task = new MergeSortTask(victim);
        forkJoinPool.submit(task);
        List<Integer> probablySorted = task.get();
        timeMark = System.currentTimeMillis() - timeMark;

        //asserting that array is sorted
        for (int i = 0; i < probablySorted.size() - 1; ++i) {
            if (probablySorted.get(i) > probablySorted.get(i + 1)) {
                throw new IllegalStateException("Sorting failed :(");
            }
        }

        System.out.println("Sorting " + LIST_SIZE + " random numbers using merge sort algorithm in " + Runtime.getRuntime().availableProcessors() + " threads took " + timeMark + " ms.");
    }
}