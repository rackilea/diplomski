boolean aPressed = false;
boolean sPressed = false;

void draw(){
  if(aPressed){
    // a is pressed
  }
  if(sPressed){
    // s is pressed
  }
}

void keyPressed(){
  if(key == 'a'){
    aPressed = true;
  }
  else if(key == 's'){
    sPressed = true;
  }
}

void keyReleased(){
  if(key == 'a'){
    aPressed = false;
  }
  else if(key == 's'){
    sPressed = false;
  }
}