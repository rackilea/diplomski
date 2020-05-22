public class PropsModule extends AbstractModule
{
    private final Props props;
    private final InProps inProps;

    private PropsModule(Props props)
    {
        this.props = props;
        this.inProps = InProps.in(props);
    }

    public static PropsModule of(Props props)
    {
        return new PropsModule(props);
    }

    @Override
    protected void configure()
    {
        bindListener(Matchers.any(), new TypeListener()
        {
            @Override
            public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter)
            {
                Class<? super I> clazz = type.getRawType();
                if (!clazz.isAnnotationPresent(WithProp.class))
                    return;
                for (Field field : clazz.getDeclaredFields())
                {
                    Prop prop = field.getAnnotation(Prop.class);
                    if (prop == null)
                        continue;

                    encounter.register(new PropInjector<I>(prop, field));
                }
            }
        });
    }

    class PropInjector<T> implements MembersInjector<T>
    {
        private final Prop prop;
        private final Field field;

        PropInjector(Prop prop, Field field)
        {
            this.prop = prop;
            this.field = field;
            field.setAccessible(true);
        }

        @Override
        public void injectMembers(T instance)
        {
            try {
                Class<?> targetType = field.getType();
                Object val = inProps.as(prop.value(), targetType);
                field.set(instance, val);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}