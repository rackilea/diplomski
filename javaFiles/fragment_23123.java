// create fonts
        float density = Gdx.graphics.getDensity();

        String path = "hdpi";
        if (density <= 1) {
            path = "mdpi";
        } else if (density > 1 && density < 1.5f) {
            path = "hdpi";
        } else if (density >= 1.5 && density < 2) {
            path = "xdpi";
        } else if (density >= 2) {
            path = "xxdpi";
        }

        normalFont = new BitmapFont(Gdx.files.internal("font/" + path + "/font.fnt"));