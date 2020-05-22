boolean control = false;
velocity.x += speed * delta;

if (Gdx.input.justTouched()){
    hasBeenTapped = true;
}

if (hasBeenTapped && getX() < 864 && control == false){
    setX(getX() + velocity.x*delta);            
}

if (getX()>864){
    setX(864);          
    control = true;         
    hasBeenTapped = false;
}

if (hasBeenTapped && getX() == 864 || getX() < 864 && control == true){
    setX(getX() - velocity.x * delta);
}

if (getX()< 0){
    setX(0);    
    control = false;
    hasBeenTapped = false;                      
}