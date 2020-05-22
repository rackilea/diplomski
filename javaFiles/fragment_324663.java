Main app = new Main();
    AppSettings settings = new AppSettings(true);
    settings.setRenderer(AppSettings.LWJGL_OPENGL_ANY);
    settings.setResolution(640, 480);
    settings.setFrameRate(30);
    app.setSettings(settings);
    app.start();