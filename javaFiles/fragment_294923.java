public void render(SpriteBatch batch, float radius, float boost) {
    speed+=boost; // rotational speed
    nextX = radius * (float) Math.cos(speed); // Offset step X
    nextY = radius * (float) Math.sin(speed); // Offset step Y

    // set image size and position
    img.setBounds(startPosition.x+nextX, startPosition.y+nextY, 100, 100);
    img.draw(batch);

    // Corrected coordinates of the image for InputAdapter coordinate system
    xPos = img.getX()+img.getWidth()/2;
    yPos = Gdx.graphics.getHeight()-img.getY()- img.getHeight()/2;

    // Check the coincidence of the coordinates of the image area and the click point
    Gdx.input.setInputProcessor(new InputAdapter(){
        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            if((Math.abs(xPos-screenX)<=img.getWidth()) && (Math.abs(yPos-screenY)<=img.getHeight()))
            {System.out.println("Image Clicked");}
            return true;
        }
    });
}