/**
 * Like {@code DoubleSummaryStatistics}, {@code IntSummaryStatistics}, and
 * {@code LongSummaryStatistics}, but for an arbitrary type {@code T}.
 */
public class SummaryStatistics<T> implements Consumer<T> {
    /**
     * Collect to a {@code SummaryStatistics} for natural order.
     */
    public static <T extends Comparable<? super T>> Collector<T,?,SummaryStatistics<T>>
                  statistics() {
        return statistics(Comparator.<T>naturalOrder());
    }
    /**
     * Collect to a {@code SummaryStatistics} using the specified comparator.
     */
    public static <T> Collector<T,?,SummaryStatistics<T>>
                  statistics(Comparator<T> comparator) {
        Objects.requireNonNull(comparator);
        return Collector.of(() -> new SummaryStatistics<>(comparator),
            SummaryStatistics::accept, SummaryStatistics::merge);
    }
    private final Comparator<T> c;
    private T min, max;
    private long count;
    public SummaryStatistics(Comparator<T> comparator) {
        c = Objects.requireNonNull(comparator);
    }

    public void accept(T t) {
        if(count == 0) {
            count = 1;
            min = t;
            max = t;
        }
        else {
            if(c.compare(min, t) > 0) min = t;
            if(c.compare(max, t) < 0) max = t;
            count++;
        }
    }
    public SummaryStatistics<T> merge(SummaryStatistics<T> s) {
        if(s.count > 0) {
            if(count == 0) {
                count = s.count;
                min = s.min;
                max = s.max;
            }
            else {
                if(c.compare(min, s.min) > 0) min = s.min;
                if(c.compare(max, s.max) < 0) max = s.max;
                count += s.count;
            }
        }
        return this;
    }

    public long getCount() {
        return count;
    }

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }

    @Override
    public String toString() {
        return count == 0? "empty": (count+" elements between "+min+" and "+max);
    }
}