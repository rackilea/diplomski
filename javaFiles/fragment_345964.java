//view model: hold info that view needs
class Model {

    private final ArrayList<Ball> balls;
    private final int width, height;

    Model(){
        balls = new ArrayList<>();
        width = 300; height = 200;
    }

    boolean addBall(Ball ball){
        return balls.add(ball);
    }

    List<Ball> getBalls() {
        return new ArrayList<>(balls); //return a copy of balls
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }
}