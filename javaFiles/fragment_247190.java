package experiments.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {
    private static String handlerMethodName;
    private final Map<Class<?>, List<HandlerMethod>> handlerMethods;

    static {
        Class<Handler> c = Handler.class;
        handlerMethodName = c.getMethods()[0].getName();
    }

    public EventBus() {
        handlerMethods = new HashMap<>();
    }

    public <T> void register(Class<T> eventClass, Handler<T> handler) {
        List<HandlerMethod> handlers = handlerMethods.computeIfAbsent(eventClass, (e) -> new ArrayList<HandlerMethod>());
        Method method = lookupMethod(handler);
        handlers.add(new HandlerMethod(handler, method));
    }

    public <T> void post(T event) {
        List<HandlerMethod> handlers = handlerMethods.get(event.getClass());

        if (handlers == null) {
            return;
        }

        for (HandlerMethod handler : handlers) {
            handler.invoke(event);
        }
    }

    private <T> Method lookupMethod(Handler<T> handler) {
        Method[] methods = handler.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(handlerMethodName)) {
                return method;
            }
        }

        // This isn't possible, but need to satisfy the compiler
        throw new RuntimeException();
    }

    /**
     * Tuple of a Handler<?> (functional interface provided by subscriber) and a {@link Method} to that function (that
     * can be invoked with an "Object" event, i.e. Method#invoke takes an Object.
     */
    private static class HandlerMethod {
        private final Handler<?> handler;
        private final Method method;

        HandlerMethod(Handler<?> handler, Method method) {
            this.handler = handler;
            this.method = method;
        }

        void invoke(Object event) {
            try {
                method.invoke(handler, event);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}