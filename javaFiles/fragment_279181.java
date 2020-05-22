public class Player {
    private int moveSpeed = 10; // mph
    private int position = 128; // Or whatever would be centered.

    public void update() {
        if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
            position += moveSpeed;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
            position -= moveSpeed;
        }
    }
}