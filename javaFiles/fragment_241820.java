public Body destroyBody(final Body body) {
 world.destroyBody(body); 
 return null; 
} 
....
body = destroyBody(body); //destroys body and set it to null in one line