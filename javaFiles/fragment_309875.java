public class AutowiredTypeListener implements TypeListener {
    public <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> typeEncounter) {
        Class<?> clazz = typeLiteral.getRawType();
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                Autowired annotation = field.getAnnotation(Autowired.class);
                if (annotation != null) {
                    typeEncounter.register(new AutowiredMembersInjector<I>(field,
                            typeEncounter.getProvider(field.getType())));
                }
            }
            clazz = clazz.getSuperclass();
        }
    }
}

public class AutowiredMembersInjector<T> implements MembersInjector<T> {
    private final Field field;
    private final Provider<?> instanceProvider;

    public AutowiredMembersInjector(Field field, Provider<?> instanceProvider) {
        this.field = field;
        this.instanceProvider = instanceProvider;

        field.setAccessible(true);
    }

    public void injectMembers(T t) {
        try {
            field.set(t, instanceProvider.get());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}