public class Engine {

    private List<Animatable> animatables;
    private Timer timer;

    public Engine() {
        animatables = new ArrayList<>(4);
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Animatable animatable : animatables) {
                    animatable.updateAnimatedState();
                }
            }
        });
    }

    public void add(Animatable animatable) {
        animatables.add(animatable);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
}