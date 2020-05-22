@Override
public void show() {
    stage = new Stage(new StretchViewport(1080, 1920));

    // May be you want to make some Actions with NavigationDrawer state
    NavigationDrawerListener listener = new NavigationDrawerListener() {

        @Override
        public void onStart() {
            System.out.println("onStart");
        }

        @Override
        public void onRun() {
            System.out.println("onRun");
        }

        @Override
        public void onFinish(float camX) {
            System.out.println("onFinish: " + camX);
        }
    };

    // You must be initialize NavigationDrawer Firstly
    NavigationDrawer.initialize(stage, listener);

    // This image is sample to show how navigationDrawer look like on the screen
    Image background= new Image(new Texture(Gdx.files.internal("background.jpg")));
    background.addListener(new ClickListener() {
        private int clicked = 0;
        public void clicked(InputEvent event, float x, float y) {
            if (clicked % 2 == 0) {
                clicked++;
                NavigationDrawer.show(true);
            } else {
                clicked++;
                NavigationDrawer.show(false);
            }
        }
    });
    background.setFillParent(true);
    stage.addActor(background);

    Gdx.input.setInputProcessor(stage);

}