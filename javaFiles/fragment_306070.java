PImage soundboard;

void setup() {  
  imageMode(CENTER);
  soundboard=loadImage("https://pbs.twimg.com/profile_images/544877364916654080/sxoWk6Sz.png");
}

void draw() {    
  image(soundboard, 25, 25);
}