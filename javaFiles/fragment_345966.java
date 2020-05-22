class BallAnimator implements Runnable{

    private final Ball ball;
    private final int maxX, maxY;
    private final Random rnd;
    private boolean moveRight = true,  moveDown = true;
    private static final int STEP =1, WAIT = 40;

    BallAnimator(Ball ball, int maxX, int maxY) {
        this.ball = ball;
        this.maxX = maxX;
        this.maxY = maxY;
        rnd = new Random();
        ball.setX(rnd.nextInt(maxX - ball.getSize()));
        ball.setY(rnd.nextInt(maxY - ball.getSize()));
        new Thread(this).start();
    }

    @Override
    public void run() {

        while(true){

            int dx = moveRight ? STEP : -STEP ;
            int dy = moveDown  ? STEP : -STEP ;

            int newX = ball.getX() + dx;
            int newY = ball.getY() + dy;

            if(newX + ball.getSize()>= maxX || newX <= 0){
                newX = ball.getX() - dx;
                moveRight = ! moveRight;
            }

            if(newY +ball.getSize()>= maxY || newY <= 0){
                newY = ball.getY() - dy;
                moveDown = ! moveDown;
            }

            ball.setX(newX);
            ball.setY(newY);

            try {
                Thread.sleep(WAIT);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}