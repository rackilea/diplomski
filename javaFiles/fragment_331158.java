private void moveSnake(int dx, int dy) {
for(int n = snake.size()-1; n >= 1; n--) {
    snake.get(n).setLocation(snake.get(n-1));
}
snake.getFirst().x += dx;
snake.getFirst().y += dy;
}