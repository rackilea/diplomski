import java.util.function.Consumer;

public interface WindowBridge {

    // SAM for this method
    public abstract class WindowOpened extends WindowAdapter {
        public abstract void windowOpened(Event e);
    }

    // factory bridge
    public static WindowOpened windowOpened(Consumer<Event> c) {
        return new WindowOpened() {
            public void windowOpened(Event e){
                c.accept(e);
            }
        };
    }

    // SAM for this method
    public abstract class WindowClosing extends WindowAdapter {
        public abstract void windowClosing(Event e);
    }

    // factory bridge
    public static WindowClosing windowClosing(Consumer<Event> c) {
        return new WindowClosing() {
            public void windowClosing(Event e){
                c.accept(e);
            }
        };
    }
}