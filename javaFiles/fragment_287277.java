public class Main {
    public static void main(String[] args) {
        final Holder holder = new Holder("abcd", (Class<Object>) (Class<?>) String.class);

        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(holder.type).toInstance(holder.instance);
            }
        });

        System.out.println(injector.getInstance(String.class));
    }

    public static class Holder {
        public final Class<Object> type;
        public final Object instance;

        public Holder(Object instance, Class<Object> type) {
            this.instance = instance;
            this.type = type;
        }
    }
}