private final Map<Class, Handler> handlers = new HashMap<Class, Handler>();

public <T> void addHandler(Class<T> clazz, Handler<T> handler) {
    handlers.put(clazz, handler);
}

@SuppressWarnings("unchecked")
public <T> Handler<T> getHandler(Class<T> clazz) {
    return (Handler<T>) handlers.get(clazz);
}

@SuppressWarnings("unchecked")
public <T> Handler<T> getHandlerFor(T t) {
    return getHandler((Class<T>) t.getClass());
}

public void run()    {
    addHandler(Foo.class, new FooHandler());
}

public <T> void handleMessage(T msg) {
    Handler<T> handler = getHandlerFor(msg);
    if (handler != null) {
        handler.execute(msg);
    }
}