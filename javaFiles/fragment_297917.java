LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.width = 640;
    config.height = 480;
    config.foregroundFPS = 60; // <- limit when focused
    config.backgroundFPS = 60; // <- limit when minimized
    config.samples =2; // AA for shape renderer.. not textures!
    new LwjglApplication(new libgdxapp(), config);