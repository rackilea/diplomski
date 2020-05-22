public PantallaJuego(MarioBros game) {

    atlas = new TextureAtlas("MarioyEnemigos.pack");
    this.game = game;
    gamecam = new OrthographicCamera();
    gamePort = new FitViewport(MarioBros.V_WIDTH / MarioBros.PPM, MarioBros.V_HEIGHT / MarioBros.PPM, gamecam);
    hud = new HUD(game.batch);
    batch = new SpriteBatch();
    controles = new Controles();