int width =  Gdx.graphics.getWidth(); \\ get the width of the device
int height = Gdx.graphics.getHeight(); \\ get the height of the device

Texture backgroundImage = new Texture(pathName);
Image image = new Image(backgroundImage);
image.setSize(width,height);  \\ background image will fill up your whole screen

Image player = new Image(new Texture(pathname)); \\ it's the same as what we did above

Stage stage = new Stage(new StretchViewport(width,height));
stage.addActor(player);  \\ add your player and background image to stage
stage.addActor(image);