public void render () {
            Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); // This cryptic line clears the screen.
            batch.begin();
            // Drawing goes here!
            batch.end();
    }