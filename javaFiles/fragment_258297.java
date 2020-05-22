@Override
public void create () {
    batch = new SpriteBatch();

    // Initiate Sprite
    img = new Texture("heavybreathing.jpg");
    sprite = new Sprite(img);
    Red = new Sprite(new Texture("Red.png"));

    screenHeight = Gdx.graphics.getHeight();
    screenWidth = Gdx.graphics.getWidth();

    font = new BitmapFont();
    font.setColor(Color.GREEN);
    font.getData().scale(5);

    Gdx.input.setInputProcessor(this);


    CircleShape circle1 = new CircleShape();
    circle1.setRadius(6f);

}