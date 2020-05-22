@Override
public void show() {

    final Image image=new Image(new TextureRegion(GdxTest.getTexture()));
    image.setSize(stage.getWidth(),stage.getHeight());
    image.setOrigin(stage.getWidth()/2,stage.getHeight()/2);
    image.setColor(Color.BLACK);

    stage.addActor(image);
    stage.addListener(new ClickListener(){

        @Override
        public void clicked(InputEvent event, float x, float y) {

            image.addAction(Actions.sequence(Actions.color(Color.BLACK,2),Actions.run(new Runnable() {
                @Override
                public void run() {
                    ((GdxTest)Gdx.app.getApplicationListener()).setScreen(new SecondScreen());
                }
            })));

            super.clicked(event, x, y);
        }
    });

    image.addAction(Actions.color(Color.WHITE,2)); 
}