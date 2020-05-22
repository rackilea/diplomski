public class Game {
    int offset_x = 0;

    public void onEvent() {
        if (move_to_left) {
            offset_x++;
        }
        else if (move_to_right) {
            offset_x--;
        }
    }

    public void paintComponent(Graphics g) {
        g.draw(backgroundImage, offset_x, y);
    }
}