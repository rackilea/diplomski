private void drawStart(){
        stageStart.draw();
    }

    public void initialize() {
        startTexture = new Texture(Gdx.files.internal("start.png"));
        startTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        stageStart = new Stage();
        stageStart.clear();
        buttonStart = new Image(startTexture);
        buttonStart.setX(10);
        buttonStart.setY(Gdx.graphics.getHeight()/2.75f);
        buttonStart.setWidth(Gdx.graphics.getWidth()/4);
        buttonStart.setHeight(Gdx.graphics.getHeight()/4);

        Gdx.input.setInputProcessor(stageStart);

        buttonStart.addListener(new ClickListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
               currentState = GameState.RESET;
               startTexture.dispose();
               stageStart.dispose();


                return true;
            }
        });
        stageStart.addActor(buttonStart);
    }

    public void dispose() {
         startTexture.dispose();
    }