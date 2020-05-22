/**
 * State of progress - returns a double result between 0 and 1.
 *
 * Will be called repeatedly by the progress tracker.
 */
interface Progress {

    public double getProgress();
}

/**
 * The progress tracker.
 */
static class ProgressTracker {

    // All processes are registered.
    static void registerProgressor(Progress p) {
        // Add it to mmy list of people to watch.
    }
}

/**
 * An Iterable that reports its progress.
 */
class ProgressingIterable<T> implements Iterable<T>, Progress {

    // The iterable we are hosting.
    final Iterable<T> it;
    // How far we are to go.
    final int steps;
    // Where we're at now.
    volatile int at = 0;

    public ProgressingIterable(Iterable<T> it, int steps) {
        this.it = it;
        this.steps = steps;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            // Grab an Iterator from the Iterable.
            Iterator<T> i = it.iterator();

            @Override
            public boolean hasNext() {
                // Delegate.
                return i.hasNext();
            }

            @Override
            public T next() {
                // Keep track of the steps.
                at++;
                return i.next();
            }

        };
    }

    @Override
    public double getProgress() {
        // How are we doing?
        return (double) at / (double) steps;
    }

}

/**
 * A range (from http://stackoverflow.com/a/6828887/823393).
 *
 * @param begin inclusive
 * @param end exclusive
 * @return list of integers from begin to end
 */
public static List<Integer> range(final int begin, final int end) {
    return new AbstractList<Integer>() {
        @Override
        public Integer get(int index) {
            return begin + index;
        }

        @Override
        public int size() {
            return end - begin;
        }
    };
}

/**
 * A process.
 */
class Process {

    ProgressingIterable<Integer> progress = new ProgressingIterable<>(range(0, 20), 20);

    public void execute() {
        // Register the Progress
        ProgressTracker.registerProgressor(progress);
        // Make the service use my progress object.
        service.calculateSum(progress);
    }

}

// The service it uses.
SumService service = new SumService();