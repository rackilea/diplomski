public class Main {
    public static void main(String[] args) {
        final Holder holder = new Holder("abcd", String.class);

        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind((Class<Object>) holder.type).toInstance(holder.instance);
            }
        });

        System.out.println(injector.getInstance(String.class));  // Prints "abcd"
    }

    public static class Holder {
        public final Class<?> type;
        public final Object instance;

        public Holder(Object instance, Class<?> type) {
            this.instance = instance;
            this.type = type;
        }
    }
}