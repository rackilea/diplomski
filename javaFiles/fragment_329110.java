OrthographicCamera camera;

int screenWidth = Gdx.graphics.getWidth();
int screenHeight = Gdx.graphics.getHeight();

camera = new OrthographicCamera(screenWidth, screenHeight);
camera.position.set(screenWidth * 0.5f, screenHeight * 0.5f, 0);