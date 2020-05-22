//If the base exceed on the right side
if(Gdx.graphics.getWidth() < posXBase + rectangleBase.getWidth()){
    //set the posXBase as far right as possible without exceed
    posXBase = Gdx.graphics.getWidth() - rectangleBase.getWidth();
//If the base exceed on the left side
else if(posXBase < 0)
    //Set the posXBase to 0
    posXBase = 0;