import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * TimedQueue is a first-in first-out queue with a fixed size that
 * replaces its oldest element if full.
 * <p>
 * The removal order of a {@link TimedQueue} is based on the
 * insertion order; elements are removed in the same order in which they
 * were added.  The iteration order is the same as the removal order.
 * <p>
 * The {@link #add(Object)}, {@link #remove()}, {@link #peek()}, {@link #poll},
 * {@link #offer(Object)} operations all perform in constant time.
 * All other operations perform in linear time or worse.
 * <p>
 * This queue prevents null objects from being added and it is not thread-safe and not serializable.
 * 
 * The majority of this source code was copied from Apaches {@link CircularFifoQueue}: http://commons.apache.org/proper/commons-collections/apidocs/org/apache/commons/collections4/queue/CircularFifoQueue.html
 *
 * @version 1.0
 */
public class TimedQueue<E> extends AbstractCollection<E>
implements Queue<E> {

/** Underlying storage array. */
private Item<E>[] elements;

/** Array index of first (oldest) queue element. */
private int start = 0;

/**
 * Index mod maxElements of the array position following the last queue
 * element.  Queue elements start at elements[start] and "wrap around"
 * elements[maxElements-1], ending at elements[decrement(end)].
 * For example, elements = {c,a,b}, start=1, end=1 corresponds to
 * the queue [a,b,c].
 */
private transient int end = 0;

/** Flag to indicate if the queue is currently full. */
private transient boolean full = false;

/** Capacity of the queue. */
private final int maxElements;

private TimeUnit unit;
private int delay;

/**
 * Constructor that creates a queue with the default size of 32.
 */
public TimedQueue() {
    this(32);
}

/**
 * Constructor that creates a queue with the specified size.
 *
 * @param size  the size of the queue (cannot be changed)
 * @throws IllegalArgumentException  if the size is &lt; 1
 */
public TimedQueue(final int size) {
    this(size, 3, TimeUnit.SECONDS);
}

@SuppressWarnings("unchecked")
public TimedQueue(final int size, int delay, TimeUnit unit) {
    if (size <= 0) {
        throw new IllegalArgumentException("The size must be greater than 0");
    }
    elements = new Item[size];
    maxElements = elements.length;
    this.unit = unit;
    this.delay = delay;
}

/**
 * Constructor that creates a queue from the specified collection.
 * The collection size also sets the queue size.
 *
 * @param coll  the collection to copy into the queue, may not be null
 * @throws NullPointerException if the collection is null
 */
public TimedQueue(final Collection<? extends E> coll) {
    this(coll.size());
    addAll(coll);
}

/**
 * Returns the number of elements stored in the queue.
 *
 * @return this queue's size
 */
@Override
public int size() {
    int size = 0;

    for(int i = 0; i < elements.length; i++) {
        if(validElement(i) != null) {
            size++;
        }
    }

    return size;
}

/**
 * Returns true if this queue is empty; false otherwise.
 *
 * @return true if this queue is empty
 */
@Override
public boolean isEmpty() {
    return size() == 0;
}

private boolean isAtFullCapacity() {
    return size() == maxElements;
}

/**
 * Clears this queue.
 */
@Override
public void clear() {
    full = false;
    start = 0;
    end = 0;
    Arrays.fill(elements, null);
}

/**
 * Adds the given element to this queue. If the queue is full, the least recently added
 * element is discarded so that a new element can be inserted.
 *
 * @param element  the element to add
 * @return true, always
 * @throws NullPointerException  if the given element is null
 */
@Override
public boolean add(final E element) {
    if (null == element) {
        throw new NullPointerException("Attempted to add null object to queue");
    }

    if (isAtFullCapacity()) {
        remove();
    }

    elements[end++] = new Item<E>(element);

    if (end >= maxElements) {
        end = 0;
    }

    if (end == start) {
        full = true;
    }

    return true;
}

/**
 * Returns the element at the specified position in this queue.
 *
 * @param index the position of the element in the queue
 * @return the element at position {@code index}
 * @throws NoSuchElementException if the requested position is outside the range [0, size)
 */
public E get(final int index) {
    final int sz = size();
    if (sz == 0) {
        throw new NoSuchElementException(
                String.format("The specified index (%1$d) is outside the available range because the queue is empty.", Integer.valueOf(index)));
    }
    if (index < 0 || index >= sz) {
        throw new NoSuchElementException(
                String.format("The specified index (%1$d) is outside the available range [0, %2$d]",
                              Integer.valueOf(index), Integer.valueOf(sz-1)));
    }

    final int idx = (start + index) % maxElements;
    return validElement(idx);
}

private E validElement(int idx) {
    if(elements[idx] == null){
        return null;
    }
    long diff = System.currentTimeMillis() - elements[idx].getCreationTime();

    if(diff < unit.toMillis(delay)) {
        return (E) elements[idx].getValue();
    } else {
        elements[idx] = null;
        return null;
    }
}

//-----------------------------------------------------------------------

/**
 * Adds the given element to this queue. If the queue is full, the least recently added
 * element is discarded so that a new element can be inserted.
 *
 * @param element  the element to add
 * @return true, always
 * @throws NullPointerException  if the given element is null
 */
public boolean offer(E element) {
    return add(element);
}

public E poll() {
    if (isEmpty()) {
        return null;
    }
    return remove();
}

public E element() {
    if (isEmpty()) {
        throw new NoSuchElementException("queue is empty");
    }
    return peek();
}

public E peek() {
    if (isEmpty()) {
        return null;
    }
    return (E) elements[start].getValue();
}

public E remove() {
    if (isEmpty()) {
        throw new NoSuchElementException("queue is empty");
    }

    final E element = validElement(start);
    if (null != element) {
        elements[start++] = null;

        if (start >= maxElements) {
            start = 0;
        }
        full = false;
    }
    return element;
}

/**
 * Increments the internal index.
 *
 * @param index  the index to increment
 * @return the updated index
 */
private int increment(int index) {
    index++;
    if (index >= maxElements) {
        index = 0;
    }
    return index;
}

/**
 * Decrements the internal index.
 *
 * @param index  the index to decrement
 * @return the updated index
 */
private int decrement(int index) {
    index--;
    if (index < 0) {
        index = maxElements - 1;
    }
    return index;
}

/**
 * Returns an iterator over this queue's elements.
 *
 * @return an iterator over this queue's elements
 */
@Override
public Iterator<E> iterator() {
    return new Iterator<E>() {

        private int index = start;
        private int lastReturnedIndex = -1;
        private boolean isFirst = full;

        public boolean hasNext() {
            return (isFirst || index != end) && size() > 0;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            isFirst = false;
            lastReturnedIndex = index;
            index = increment(index);
            if(validElement(lastReturnedIndex) == null) {
                return next();
            } else {
                return validElement(lastReturnedIndex);
            }
        }

        public void remove() {
            if (lastReturnedIndex == -1) {
                throw new IllegalStateException();
            }

            // First element can be removed quickly
            if (lastReturnedIndex == start) {
                TimedQueue.this.remove();
                lastReturnedIndex = -1;
                return;
            }

            int pos = lastReturnedIndex + 1;
            if (start < lastReturnedIndex && pos < end) {
                // shift in one part
                System.arraycopy(elements, pos, elements, lastReturnedIndex, end - pos);
            } else {
                // Other elements require us to shift the subsequent elements
                while (pos != end) {
                    if (pos >= maxElements) {
                        elements[pos - 1] = elements[0];
                        pos = 0;
                    } else {
                        elements[decrement(pos)] = elements[pos];
                        pos = increment(pos);
                    }
                }
            }

            lastReturnedIndex = -1;
            end = decrement(end);
            elements[end] = null;
            full = false;
            index = decrement(index);
        }

    };
}

private static final class Item<E> {
    private long creationTime;
    private E in;

    public Item(E in) {
        this.in = in;
        creationTime = System.currentTimeMillis();
    }

    public E getValue() {
        return in;
    }

    public long getCreationTime() {
        return creationTime;
    }
}
}