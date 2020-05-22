direction = new Vector2(0,1);
//an easy way to make it go 45 degree up/right would be
direction = new Vector2(1,1);
direction.nor(); //normalized to 1 long.

//now we can make the velocity

velocity = direction.cpy().scl(speed); //we copy the vector first so we are not changing the direction vector. 
//If you want to have this framerate independent 
velocity = direction.cpy().scl(speed * Gdx.graphics.getDeltatime);