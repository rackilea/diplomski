public class Game extends JPanel implements InputHandler {

    private Set<Input> inputSet = new HashSet<>();
    //...
    public Game() {
        //...
        addKeyListener(new KeyHandler(this));
        //...
    }

    @Override
    public synchronized void add(Input input) {
        inputSet.add(input);
    }

    @Override
    public synchronized void remove(Input input) {
        inputSet.remove(input);
    }