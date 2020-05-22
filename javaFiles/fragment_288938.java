Matrix4 mx4Font = new Matrix4();
BitmapFont font;
SpriteBatch spriteFont;

font = new BitmapFont(Gdx.files.internal("data/font/agencyFB.fnt"), Gdx.files.internal("data/font/agencyFB.png"), true); //must be set true to be flipped
mx4Font.setToRotation(new Vector3(200, 200, 0), 180);
spriteFont.setTransformMatrix(mx4Font);
spriteFont.begin();
font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
font.draw(spriteFont, "The quick brown fox jumped over the lazy dog", 100, 110);
spriteFont.end();