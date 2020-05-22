public class KennelModule extends Abstract Module {
    @Override
    protected void configure() {
        bind(Creature.class).annotatedWith(Names.named("foo").to(Dragon.class);
    }
}