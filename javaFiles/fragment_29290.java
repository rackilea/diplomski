public void update(float delta){
    x += dx * xSpeed * delta;
    y += dy * ySpeed * delta;
    rotation += rotDirection * rotationSpeed * delta;
    y += yMoveSpeed * delta;
}