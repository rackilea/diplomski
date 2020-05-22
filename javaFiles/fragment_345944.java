public class Player {

    private Paddle paddle;
    private KeyPressedChecker kpc;

    public Player(KeyPressedChecker kpc) {
        this.paddle = new Paddle();
        this.kpc = kpc ;
    }

    public Rectangle getPaddleDrawable() {
        return paddle.getDrawable();
    }

    public void update() {
        if (kpc.isDownPressed())
            paddle.moveDown();
        paddle.update();
    }
}