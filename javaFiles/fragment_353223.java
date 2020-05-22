public class DefaultsModule extends AbstractModule
{

        private static class Defaults implements com.mycompany.guice.Defaults, Serializable
    {
        private final Class value;

        private Defaults() { this.value = null; }

        Defaults(@Nonnull final Class value) { this.value = checkNotNull(value); }

        public Class value() { return this.value; }

        public int hashCode() { /* This is specified in java.lang.Annotation. */ return (127 * "value".hashCode()) ^ value.hashCode(); }

        @Override
        public Class<? extends Annotation> annotationType() { return com.mycompany.guice.Defaults.class; }

        public boolean equals(Object o)
        {
            if (!(o instanceof Defaults)) { return false; }
            com.mycompany.guice.Defaults other = (com.mycompany.guice.Defaults) o;
            return value.equals(other.value());
        }
    }

    @Override
    protected void configure()
    {
        bind(new TypeLiteral<Map<String, Object>>() {}).annotatedWith(new Defaults(MyClassThatNeedsDefaults.class)).toInstance(/* omitted for brevity */);
    }
}