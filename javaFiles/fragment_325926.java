import com.google.common.base.MoreObjects;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Table;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.concurrent.GuardedBy;

/**
 * Provide something like the {@link com.google.common.util.concurrent.AtomicLongMap} but supporting
 * multiple keys.
 *
 * Should be able to put a value using two keys. And retrieve either a precise cell. Or retrieve a
 * collection of values.
 *
 * Created by James on 28/02/2017.
 */
public class SynchronizedMultimap<Row, Column, Value> {

    private final Object mutex = new Object();
    @GuardedBy("mutex") // All read and write access to delegate must be protected by mutex.
    private final Table<Row, Column, Value> delegate = HashBasedTable.create();

    /**
     * {@link Table#put(Object, Object, Object)}
     * Associates the specified value with the specified keys. If the table
     * already contained a mapping for those keys, the old value is replaced with
     * the specified value.
     *
     * @return The old value associated with the keys or {@code null} if no previous value existed.
     */
    public Value put(Row row, Column column, Value value) {
        synchronized (mutex) {
            return delegate.put(row, column, value);
        }
    }

    /**
     * {@link java.util.concurrent.ConcurrentMap#computeIfAbsent(Object, Function)}
     *
     * Checks the existing value in the table delegate by {@link Table#get(Object, Object)} and
     * applies the given function, the function in this example should be able to handle a null input.
     *
     * @return The current value of the Table for keys, whether the function is applied or not.
     */
    public Value compute(Row row, Column column, Function<Value, Value> function) {
        synchronized (mutex) {
            Value oldValue = delegate.get(row, column);
            Value newValue = function.apply(oldValue);
            if (newValue != null) {
                delegate.put(row, column, newValue);
                return newValue;
            }
            return oldValue;
        }
    }

    /**
     * {@link Table#get(Object, Object)}
     *
     * @return The value associated with the keys or {@code null} if no value.
     */
    public Value get(Row row, Column column) {
        synchronized (mutex) {
            return delegate.get(row, column);
        }
    }

    /**
     * {@link Table#row(Object)}
     *
     * @return An immutable map view of the columns in the table.
     */
    public Map<Column, Value> get(Row row) {
        synchronized (mutex) {
            // Since we are exposing
            return ImmutableMap.copyOf(delegate.row(row));
        }
    }

    @Override
    public String toString() {
        // Even toString needs protection.
        synchronized (mutex) {
            return MoreObjects.toStringHelper(this)
                .add("delegate", delegate)
                .toString();
        }
    }
}