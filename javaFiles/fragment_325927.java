/**
 * Provides support for similar behaviour as AtomicLongMap.
 *
 * Created by James on 28/02/2017.
 */
public class SynchronizedLongMultimap<Row, Column> extends SynchronizedMultimap<Row, Column, Long> {

    /**
     * @return Adds delta to the current value and returns the new value. Or delta if no previous value.
     */
    public long addAndGet(Row row, Column column, long delta) {
        return compute(row, column,
            (Long oldValue) -> (oldValue == null) ? delta : oldValue + delta);
    }

    /**
     * @return Increments the current value and returns the new value. Or 1 if no previous value.
     */
    public long increment(Row row, Column column) {
        return compute(row, column, (Long oldValue) -> (oldValue == null) ? 1 : oldValue + 1);
    }

    /**
     * @return Decrements the current value and returns the new value. Or -1 if no previous value.
     */
    public long decrement(Row row, Column column) {
        return compute(row, column, (Long oldValue) -> (oldValue == null) ? -1 : oldValue - 1);
    }
}