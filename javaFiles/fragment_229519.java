package myNamespace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import myNamespace.ThrowingFunction;
import myNamespace.ThrowingSupplier;

/** Collection of AutoCloseable objects */
public class ResourceCollection<T extends AutoCloseable>
        implements Iterable<T>, AutoCloseable {

    /** Resources owned by this instance */
    private final List<T> myResources;

    /**
     * Constructor
     * @param allocator Function used to allocate each resource
     * @param count     Number of times to call the allocator
     * @throws E Thrown if any of the allocators throw
     */
    public <E extends Throwable> ResourceCollection(
            final ThrowingSupplier<T, E> allocator, final int count)
            throws E {
        myResources = new ArrayList<>(count);
        try {
            while (myResources.size() < count) {
                final T resource = allocator.getThrows();
                myResources.add(resource);
            }
        } catch (final Throwable e) {
            close();
            throw e;
        }
    }

    /**
     * Constructor
     * @param allocator Function used to allocate each resource
     * @param input     List of input parameters passed to the allocator
     * @throws E Thrown if any of the allocators throw
     */
    public <U, E extends Throwable> ResourceCollection(
            final ThrowingFunction<U, T, E> allocator, final Collection<U> input)
            throws E {
        myResources = new ArrayList<>(input.size());
        try {
            for (final U value : input) {
                final T resource = allocator.applyThrows(value);
                myResources.add(resource);
            }
        } catch (final Throwable e) {
            close();
            throw e;
        }
    }

    /**
     * Gets the number of resources in the collection
     * @return The number of resources in the collection
     */
    public int size() {
        return myResources.size();
    }

    /**
     * Gets whether the collection contains no resources
     * @return Whether the collection contains no resources
     */
    public boolean isEmpty() {
        return myResources.isEmpty();
    }

    /**
     * Gets the resource at index i
     * @param i The index of a resource, in the range [0, size())
     * @return The resource at index i
     */
    public T get(final int i) {
        return myResources.get(i);
    }

    @Override
    public Iterator<T> iterator() {
        return myResources.iterator();
    }

    @Override
    public void close() {
        final ListIterator<T> resourceIter =
                myResources.listIterator(myResources.size());
        while (resourceIter.hasPrevious()) {
            final T resource = resourceIter.previous();
            if (resource != null) {
                try {
                    resource    .close ();
                    resourceIter.remove();
                } catch (final Throwable t) {
                    // Eat the exception
                }
            }
        }
    }

}