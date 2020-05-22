public class BallImpl implements Ball {
    List<BallBehavior> behaviors = ...

    @Override
    public void update() {
       behaviors.forEach(behavior -> behavior.update(this));
    }
    ...
}

public interface BallBehavior {
    void update(BallImpl ballImpl);
}