import static com.google.common.base.Preconditions.checkNotNull;

class Player implements SomeInterface {
    private final String name;

    @Inject
    Player(String name) {
        this.name = checkNotNull(name);
    }

    ...
}