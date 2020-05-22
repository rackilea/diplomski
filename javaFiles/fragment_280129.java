public static class ArcsPanel extends JPanel implements Animatable {
    //...
    @Override
    public void updateAnimatedState() {
        angle += DELTA;
        repaint();
    }
}

public class StillClock extends JPanel implements Animatable {
    //...

    @Override
    public void updateAnimatedState() {
        setCurrentTime();
        repaint();
    }
}