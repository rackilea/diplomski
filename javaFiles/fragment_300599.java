public void update() {
    if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
        if (isConnected) {
            isConnected = false;
        }
        else if (isConnectable(redSquare.position)) {
            isConnected = true;
        }
    }

    if (isConnected) {
        position.x = redSquare.position.x + 40;
        position.y = redSquare.position.y;
    }
}

private boolean isConnectable(Vector2 pos) {
    if (position.x - pos.x == 40 && position.y == pos.y)
        return true;
    return false;
}