public class Car implements SpeedProvider {
    int maxSpeed = 220;

    @Override
    public int getSpeed() {
        return maxSpeed;
    }
}

public class Train implements SpeedProvider {
    int maxSpeed = 300;

    @Override
    public int getSpeed() {
        return maxSpeed;
    }
}