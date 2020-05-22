public class TestMagic {
    public static void main(final String... arg) {
        Guice.createInjector(
                new AbstractModule() {
                    @Override
                    protected void configure() {
                        bind(String.class).annotatedWith(Names.named("testString")).toInstance("Guice!");

                        bind(LegacyThing.class).toProvider(new MagicLegacyProvider<>(LegacyThingImp.class, Key.get(String.class, Names.named("testString"))));
                    }
                }).getInstance(LegacyThing.class);
    }
}