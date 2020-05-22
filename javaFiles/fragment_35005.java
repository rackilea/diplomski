float widthInches = (float)Gdx.graphics.getWidth() * Gdx.graphics.getPpiX();
float heightInches = (float)Gdx.graphics.getHeight() * Gdx.graphics.getPpiY();
stage = new Stage(new StretchViewport(widthInches, heightInches));
...
// e.g. if you want your buttons to be 1 by 1 inch 
button.setSize(1f, 1f);
button.getStyle().up.setMinWidth(1f);
button.getStyle().up.setMinHeight(1f);
... etc. for the other drawables your button uses