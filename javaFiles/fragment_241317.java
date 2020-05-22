/**
 * An anstract base class for implementing the {@link AttributeHolder}
 * interface which has an implementation of the attribute related methods.
 *
 * @author Matthias Treydte &lt;waldheinz at gmail.com&gt;
 */
public abstract class AbstractAttributeHolder
        implements AttributeHolder, Disposable {

    private final Object lock = new Object();
    private transient Map<Object, Object> attributes;

    public AbstractAttributeHolder() {
        this.attributes = new HashMap<Object, Object>();
    }

    public void replaceAttributes(Map<Object, Object> newAttr) {
        synchronized (getAttributeLock()){
            this.attributes = newAttr;
        }
    }

    @Override
    public Object getAttributeLock() {
        return this.lock;
    }

    @Override
    public final void putAttribute(Object key, Object value) {
        synchronized (getAttributeLock()) {
            attributes.put(key, value);
        }
    }

    @Override
    public final boolean hasAttribute(Object key) {
        synchronized (getAttributeLock()) {
            return attributes.containsKey(key);
        }
    }

    @Override
    public final Object getAttribute(Object key) {
        synchronized (getAttributeLock()) {
            return attributes.get(key);
        }
    }

    @Override
    public final Set<Object> getAttributes() {
        synchronized (getAttributeLock()) {
            return Collections.unmodifiableSet(
                    new HashSet<Object>(this.attributes.values()));
        }
    }

    @Override
    public void dispose() {
        synchronized (this.getAttributeLock()) {
            for (Object o : this.attributes.values()) {
                if (o instanceof Disposable) {
                    final Disposable d = (Disposable) o;
                    d.dispose();
                }
            }

            this.attributes.clear();
        }
    }
}