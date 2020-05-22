@Override
    public void resize(int width, int height) {
        Gdx.app.log("Screen", "Resize screen: " + getName());
        cam.viewportHeight = height;
        cam.viewportWidth = width;
        if (Config.VIRTUAL_VIEW_WIDTH / cam.viewportWidth < Config.VIRTUAL_VIEW_HEIGHT
                / cam.viewportHeight) {
            cam.zoom = Config.VIRTUAL_VIEW_HEIGHT / cam.viewportHeight;
        } else {
            cam.zoom = Config.VIRTUAL_VIEW_WIDTH / cam.viewportWidth;
        }
        cam.update(); // update it ;)
    }