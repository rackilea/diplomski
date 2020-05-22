import com.google.common.collect.ForwardingMap;

// ...

Field mrfoField = KeyboardFocusManager.class.getDeclaredField("mostRecentFocusOwners");
mrfoField.setAccessible(true);
final Map delegate = (Map) mrfoField.get(null);
Map mrfo = new ForwardingMap() {
    public Object put(Object key, Object value) {
        new Throwable().printStackTrace();
        return super.put(key, value);
    }
    protected Map delegate() {
        return delegate;
    }
};
mrfoField.set(null, mrfo);