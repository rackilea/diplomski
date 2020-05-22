Sprite sprite = new Sprite(x, y, texture, this.getVertexBufferObjectManager()) {

    public boolean onAreaTouched(org.andengine.input.touch.TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) 
    {
        //<DO ANYTHING this.setPosition(x,y) method to move the sprite>
        this.setPosition(this.getX() + 10 , this.getY() + 10);
        return true;
    };
};
scene.setTouchAreaBindingOnActionDownEnabled(true);
scene.registerTouchArea(sprite);