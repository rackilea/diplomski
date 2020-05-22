public void create() {
  walkSheet = new Texture(Gdx.files.internal("animation_sheet.png")); // #9
  TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_ROWS);              // #10
  walkFrames = new TextureRegion[FRAME_COLS];
  anim = new Animation[FRAME_ROWS];
  for (int i = 0; i < FRAME_ROWS; i++) {
    for (int j = 0; j < FRAME_COLS; j++) {
      walkFrames[j] = tmp[i][j];
    }
    anim[i] = new Animation(0.025f, walkFrames);
  }
  spriteBatch = new SpriteBatch();                // #12
  stateTime = 0f;                         // #13
}