public class CompositeRequestScope implements Scope {
    private final Scope requestScope = new RequestScope();
    private final Scope fallbackScope = new SimpleThreadScope();

    public Object get(String name, ObjectFactory<?> objectFactory) {
        return activeScope().get(name, objectFactory);
    }

    ...

    private Scope activeScope() {
        if (RequestContextHolder.getRequestAttributes() != null) {
            return requestScope;    
        } else {
            return fallbackScope;
        }
    }
}