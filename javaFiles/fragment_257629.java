interface Handler<T extends Message> {
...}


interface Message {...}

interface HandlerContainer {

    <T extends Message> void register(Class<T> clazz, Handler<T> handler);

    <T extends Message> Handler<T> getHandler(T t);

}


class HandlerContainerImpl implements HandlerContainer {

    private final Map<Class<?>,Handler<?>> handlers = new HashMap<Class<?>,Handler<?>>();

    <T extends Message> void register(Class<T> clazz, Handler<T> handler) {
          if (clazz==null || handler==null) {
             throw new IllegalArgumentException();
          }
          handlers.put(clazz,handler);
    }

    //Type safety is assured by the register message and generic bounds
    @SuppressWarnings("unchecked")
    <T extends Message> Handler<T> getHandler(T t) {
            return  (Handler<T>)handlers.get(t.getClass());

    }

}