public class ProxyNativeJavaPackage extends ScriptableObject implements Serializable {
    static final long serialVersionUID = 1L;

    protected final NativeJavaPackage delegate;
    private final Map<String, Object> mutations = new HashMap<String, Object>();

    public ProxyNativeJavaPackage(NativeJavaPackage delegate) {
        delegate.getClass();
        this.delegate = delegate;
    }

    @Override
    public String getClassName() {
        return delegate.getClassName();
    }

    @Override
    public boolean has(String id, Scriptable start) {
        return mutations.containsKey(id) ? mutations.get(id) != null : delegate.has(id, start);
    }

    @Override
    public boolean has(int index, Scriptable start) {
        return delegate.has(index, start);
    }

    @Override
    public void put(String id, Scriptable start, Object value) {
        mutations.put(id, value);
    }

    @Override
    public void put(int index, Scriptable start, Object value) {
        delegate.put(index, start, value);
    }

    @Override
    public Object get(String id, Scriptable start) {
        if (mutations.containsKey(id)) {
            return mutations.get(id);
        }
        return delegate.get(id, start);
    }

    @Override
    public Object get(int index, Scriptable start) {
        return delegate.get(index, start);
    }

    @Override
    public Object getDefaultValue(Class<?> ignored) {
        return toString();
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProxyNativeJavaPackage) {
            ProxyNativeJavaPackage that = (ProxyNativeJavaPackage) obj;
            return delegate.equals(that.delegate) && mutations.equals(that.mutations);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }
}