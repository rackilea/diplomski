public class WindowedGame<T extends Game<Graphics2D>>
        extends GameContainer<T> {
    ...
}

public abstract class GameContainer<T extends Game<?>> {
    ....
}