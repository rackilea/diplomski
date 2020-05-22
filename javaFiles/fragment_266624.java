interface Creature { }

class Dragon implements Creature { }
class Dog implements Creature { }

public class Kennel {
    @Inject @Named("foo") Creature c;
}

public class KennelModule extends Abstract Module {
    @Override
    protected void configure() {
        bind(Dragon.class).annotatedWith(Names.named("foo"));
        bind(Dog.class).annotatedWith(Names.named("foo"));
    }
}