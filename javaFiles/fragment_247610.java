int ROW = 4;  // rows of sprite sheet image
    int COLUMN = 4;
    TextureRegion[][] tmp = TextureRegion.split(playerTexture, playerTexture.getWidth() / COLUMN, playerTexture.getHeight() / ROW);
    TextureRegion[] frames = new TextureRegion[ROW * COLUMN];
    int elementIndex = 0;
    for (int i = 0; i < ROW; i++) {
        for (int j = 0; j < COLUMN; j++) {
            frames[elementIndex++] = tmp[i][j];
        }
    }
    Animation playerAnimation = new Animation(1, frames);