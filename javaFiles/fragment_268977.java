import java.util.*;

abstract class Ball implements Cloneable {
    abstract String getName();
    public Ball clone() {
        Ball ball;
        try {
            ball = (Ball)super.clone();
        } catch (CloneNotSupportedException e) {
            ball = null;
        }
        return ball;
    }
}

class SmallBall extends Ball {
    public String getName() { return "smallBall"; }
}

class MediumBall extends Ball {
    public String getName() { return "mediumBall"; }
}

class LargeBall extends Ball {
    public String getName() { return "largeBall"; }
}

class RandomBallFactory {
    private final List<Ball> prototypes;

    public RandomBallFactory() {
        prototypes = new ArrayList<Ball>();
    }

    public void registerBall(Ball ball) {
        prototypes.add(ball);
    }

    public Ball createBall() {
        Random randomGenerator = new Random();
        Integer randomNumber = randomGenerator.nextInt(prototypes.size());
        return prototypes.get(randomNumber).clone();
    }
}

public class TestBalls {
    public static void main(String[] args) {
        RandomBallFactory randomBallFactory = new RandomBallFactory();
        randomBallFactory.registerBall(new SmallBall());
        randomBallFactory.registerBall(new MediumBall());
        randomBallFactory.registerBall(new LargeBall());

        Ball ball = randomBallFactory.createBall();
        System.out.println(ball.getName());
    }
}